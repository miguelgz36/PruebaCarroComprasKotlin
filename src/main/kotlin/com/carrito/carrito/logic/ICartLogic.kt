package com.carrito.carrito.logic

import com.carrito.carrito.model.Cart

interface ICartLogic {

    fun checkOut(idCart: Long): Boolean


    fun list(): MutableList<Cart>
}