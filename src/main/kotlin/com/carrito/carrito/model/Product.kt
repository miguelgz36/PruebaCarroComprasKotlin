package com.carrito.carrito.model

import javax.persistence.*

@Entity
@Table ( name = "products")
data class Product(val nombre:String = "", val sku:String = "", val descripcion:String = ""){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L;

}

