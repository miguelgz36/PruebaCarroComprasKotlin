package com.carrito.carrito

import com.carrito.carrito.dao.CartRepository
import com.carrito.carrito.dao.ProductCartRepository
import com.carrito.carrito.dao.ProductRepository
import com.carrito.carrito.model.Cart
import com.carrito.carrito.model.Product
import com.carrito.carrito.model.ProductCart
import com.carrito.carrito.utils.EnumStatusCart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
@EnableJpaRepositories("com.carrito.carrito.dao")
@EntityScan("com.carrito.carrito.model")
class CarritoComprasApplication:CommandLineRunner{

	@Autowired
	val productRepository: ProductRepository?= null

	@Autowired
	val cartRepository: CartRepository?= null

	@Autowired
	val productCartRepository: ProductCartRepository?= null

	override fun run(vararg args: String?) {
		fillTestData()
	}
	fun fillTestData(){
		val products: MutableList<Product> = mutableListOf()

		products.add(Product("tornillo", "DF2F324", "Un tornillo"))
		products.add(Product("bombillo", "DF2F32423", "Un bombillo"))
		products.add(Product("Sierra", "D2323F324", "Una sierra"))

		productRepository!!.saveAll(products)

		val carts: MutableList<Cart> = mutableListOf()

		carts.add(Cart(EnumStatusCart.PENDING))
		carts.add(Cart(EnumStatusCart.PENDING))
		carts.add(Cart(EnumStatusCart.COMPLETED))

		cartRepository!!.saveAll(carts)

		var productCart = ProductCart(10.0)
		productCart.cart = carts[0]
		productCart.product = products[0]

		productCartRepository!!.save(productCart)

		productCart = ProductCart(20.0)
		productCart.cart = carts[0]
		productCart.product = products[1]

		productCartRepository!!.save(productCart)

	}

	@Bean
	fun corsConfigurer(): WebMvcConfigurer? {
		return object : WebMvcConfigurer {
			override fun addCorsMappings(registry: CorsRegistry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE")
			}
		}
	}


}

fun main(args: Array<String>) {
	runApplication<CarritoComprasApplication>(*args)
}
