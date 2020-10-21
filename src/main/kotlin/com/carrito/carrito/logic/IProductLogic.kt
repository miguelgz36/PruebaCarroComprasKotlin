package com.carrito.carrito.logic

import com.carrito.carrito.model.Product

interface IProductLogic {

    fun listarProductos(pagina: Int, cantidadPorPagina: Int): List<Product>

}