package com.carrito.carrito.logic

import com.carrito.carrito.model.Product

interface IProductLogic {

    fun list(page: Int, size: Int): List<Product>

}