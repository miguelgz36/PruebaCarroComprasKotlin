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
    val productRepository: ProductRepository ?= null

    override fun list(page: Int, size: Int): List<Product> {
        val result: MutableList<Product> = mutableListOf()

        val pageable: PageRequest = PageRequest.of(page, size)
        val pageProducts: Page<Product> = productRepository!!.findAll(pageable)

        pageProducts.onEach { product: Product ->
            result.add(product)
        }

        return result
    }

}