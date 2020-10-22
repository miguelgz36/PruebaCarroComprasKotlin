package com.carrito.carrito.dao

import com.carrito.carrito.model.ProductCart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCartRepository: JpaRepository<ProductCart, Long>