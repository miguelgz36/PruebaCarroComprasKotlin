package com.carrito.carrito

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.carrito.carrito.dao")
@EntityScan("com.carrito.carrito.model")
class CarritoComprasApplication

fun main(args: Array<String>) {
	runApplication<CarritoComprasApplication>(*args)
}
