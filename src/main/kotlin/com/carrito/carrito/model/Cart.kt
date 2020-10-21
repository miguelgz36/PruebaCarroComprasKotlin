package com.carrito.carrito.model

import com.carrito.carrito.utils.StatusCart
import javax.persistence.*

@Entity
@Table (name = "carts")
data class Cart(var status: StatusCart) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

}