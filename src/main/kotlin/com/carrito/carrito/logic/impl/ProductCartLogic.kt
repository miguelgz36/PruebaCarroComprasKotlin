package com.carrito.carrito.logic.impl

import com.carrito.carrito.dao.CartRepository
import com.carrito.carrito.dao.ProductCartRepository
import com.carrito.carrito.dao.ProductRepository
import com.carrito.carrito.logic.IProductCartLogic
import com.carrito.carrito.model.Cart
import com.carrito.carrito.model.Product
import com.carrito.carrito.model.ProductCart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProductCartLogic: IProductCartLogic {

    @Autowired
    var productRepository: ProductRepository ?= null

    @Autowired
    var cartRepository: CartRepository ?= null

    @Autowired
    var productCartRepository: ProductCartRepository ?= null

    override fun createProductCart(product_id: Long, cart_id: Long, quantity: Double): ProductCart {
        var newProductCart: ProductCart = ProductCart(quantity)
        var productOptional: Optional<Product> = productRepository!!.findById(product_id)
        var carOptional: Optional<Cart> = cartRepository!!.findById(cart_id)

        if(productOptional.isPresent && carOptional.isPresent){
            newProductCart.product = productOptional.get()
            newProductCart.cart = carOptional.get()
            productCartRepository!!.save(newProductCart)
        }else{
            TODO("Make exception")
        }

        return newProductCart
    }

    override fun deleteProductCart(id: Long) {
        productCartRepository?.deleteById(id)
    }

    override fun modifyQuantity(idProductCars: Long, newQuantity: Double): Double {
        var productCart: ProductCart ?= null
        var productCartOptional: Optional<ProductCart> = productCartRepository!!.findById(idProductCars)

        if(productCartOptional.isPresent){
            productCart = productCartOptional.get()
            productCart.quantity = newQuantity
            productCartRepository?.save(productCart)
        }else{
            TODO("Make exception")
        }
        return productCart.quantity
    }

}