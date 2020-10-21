package com.carrito.carrito.logic.impl

import com.carrito.carrito.dao.ProductRepository
import com.carrito.carrito.logic.IProductLogic
import com.carrito.carrito.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class ProductLogic: IProductLogic {

    @Autowired
    var productRepository: ProductRepository ?= null

    override fun listarProductos(pagina: Int, cantidadPorPagina: Int): List<Product> {
        var result: MutableList<Product> = mutableListOf()

        var pageable: PageRequest = PageRequest.of(pagina, cantidadPorPagina)
        var page: Page<Product> = productRepository?.findAll(pageable) ?: Page.empty()

        page.onEach { product: Product -> {
            result.add(product);
        } }

        return result
    }

}