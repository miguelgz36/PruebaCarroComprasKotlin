package com.carrito.carrito.logic.impl

import com.carrito.carrito.dao.CartRepository
import com.carrito.carrito.dao.ProductCartRepository
import com.carrito.carrito.dao.ProductRepository
import com.carrito.carrito.logic.IProductCartLogic
import com.carrito.carrito.model.Cart
import com.carrito.carrito.model.Product
import com.carrito.carrito.model.ProductCart
import com.carrito.carrito.utils.EnumStatusCart
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.Exception
import java.util.*

@Component
class ProductCartLogic: IProductCartLogic {

    @Autowired
    val productRepository: ProductRepository ?= null

    @Autowired
    val cartRepository: CartRepository ?= null

    @Autowired
    val productCartRepository: ProductCartRepository ?= null

    override fun createProductCart(product_id: Long, cart_id: Long, quantity: Double): ProductCart {
        val newProductCart= ProductCart(quantity)
        val productOptional: Optional<Product> = productRepository!!.findById(product_id)
        val cartOptional: Optional<Cart> = cartRepository!!.findById(cart_id)
        if(!productOptional.isPresent){
            throw NotFoundException("Producto no existe ")
        }
        if(!cartOptional.isPresent){
            throw NotFoundException("Carro de compras no existe ")
        }
        if(cartOptional.get().status == EnumStatusCart.COMPLETED){
            throw NotFoundException("El carrito ya esta completado ")
        }
        if(quantity <= 0){
            throw Exception("Cantidad negativa")
        }

        newProductCart.product = productOptional.get()
        newProductCart.cart = cartOptional.get()
        productCartRepository!!.save(newProductCart)


        return newProductCart
    }

    override fun deleteProductCart(id: Long): Boolean{
        val productCartOptional: Optional<ProductCart> = productCartRepository!!.findById(id)
        if(!productCartOptional.isPresent){
            return false
        }
        if(productCartOptional.get().cart.status == EnumStatusCart.COMPLETED){
            return false
        }
        productCartRepository?.deleteById(id)
        return true
    }

    override fun modifyQuantity(idProductCars: Long, newQuantity: Double): Double {
        val productCart: ProductCart?
        val productCartOptional: Optional<ProductCart> = productCartRepository!!.findById(idProductCars)

        if(!productCartOptional.isPresent){
            throw NotFoundException("Producto del carro no existe ")
        }
        if(productCartOptional.get().cart.status == EnumStatusCart.COMPLETED){
            throw NotFoundException("El carrito ya esta completado ")
        }
        if(newQuantity <= 0){
            throw Exception("Cantidad negativa")
        }
        productCart = productCartOptional.get()
        productCart.quantity = newQuantity
        productCartRepository?.save(productCart)

        return productCart.quantity
    }
    //Para pruebas
    override fun list(): MutableList<ProductCart> {
        return productCartRepository!!.findAll()
    }

}