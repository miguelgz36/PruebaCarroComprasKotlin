package com.carrito.carrito.logic.impl

import com.carrito.carrito.dao.CartRepository
import com.carrito.carrito.logic.ICartLogic
import com.carrito.carrito.model.Cart
import com.carrito.carrito.utils.EnumStatusCart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class CartLogic: ICartLogic {

    @Autowired
    val cartRepository: CartRepository ?= null

    override fun checkOut(idCart: Long): Boolean {

        val optionalCart: Optional<Cart> = cartRepository!!.findById(idCart)
        if(optionalCart.isPresent && optionalCart.get().status == EnumStatusCart.PENDING){
            optionalCart.get().status = EnumStatusCart.COMPLETED
            cartRepository!!.save(optionalCart.get())
            return true
        }
        return false
    }

    //Para pruebas
    override fun list(): MutableList<Cart> {
        return cartRepository!!.findAll()
    }

}