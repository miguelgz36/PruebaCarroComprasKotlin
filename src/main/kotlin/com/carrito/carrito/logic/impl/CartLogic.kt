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
    var cartRepository: CartRepository ?= null

    override fun checkOut(idCart: Long): Boolean {

        var optionalCart: Optional<Cart> = cartRepository?.findById(idCart) ?: Optional.empty()
        if(optionalCart.isPresent){
            optionalCart.get().status = EnumStatusCart.COMPLETED
            return true
        }
        return false
    }

}