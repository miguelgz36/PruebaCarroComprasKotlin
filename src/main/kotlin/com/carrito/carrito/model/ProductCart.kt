package com.carrito.carrito.model

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table( name = "product_cars")
data class ProductCart (var quantity: Double){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

    @OneToOne
    @NotNull
    lateinit var product: Product

    @OneToOne
    @NotNull
    lateinit var cart: Cart
}