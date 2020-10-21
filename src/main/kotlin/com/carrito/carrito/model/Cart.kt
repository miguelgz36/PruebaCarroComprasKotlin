package com.carrito.carrito.model

import com.carrito.carrito.utils.EnumStatusCart
import javax.persistence.*

@Entity
@Table (name = "carts")
data class Cart(var status: EnumStatusCart) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

}