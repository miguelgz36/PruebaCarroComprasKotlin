package com.carrito.carrito.dao

import com.carrito.carrito.model.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository: JpaRepository<Cart, Long>