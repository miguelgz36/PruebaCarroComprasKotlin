package com.carrito.carrito.logic

import com.carrito.carrito.model.ProductCart

interface IProductCartLogic {

    fun createProductCart(product_id: Long, cart_id: Long, quantity: Double): ProductCart
    fun deleteProductCart(id: Long): Boolean
    fun modifyQuantity(idProductCars: Long, newQuantity: Double): Double


    fun list(): MutableList<ProductCart>

}