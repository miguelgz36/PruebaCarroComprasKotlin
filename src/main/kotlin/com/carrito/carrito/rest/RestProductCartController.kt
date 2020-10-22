package com.carrito.carrito.rest

import com.carrito.carrito.logic.IProductCartLogic
import com.carrito.carrito.model.ProductCart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("productsCart")
class RestProductCartController {

    @Autowired
    val productCartLogic: IProductCartLogic ?= null

    @PostMapping("addProductToCart")
    fun createProductCart(@RequestParam product_id: Long, @RequestParam cart_id: Long, @RequestParam quantity: Double) : ResponseEntity<ProductCart> {
        return try {
            ResponseEntity(productCartLogic!!.createProductCart(product_id, cart_id, quantity), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("deleteProductFromCart/{id}")
    fun deleteProductCart(@PathVariable("id") id: Long) : ResponseEntity<Boolean> {
        return try {
            ResponseEntity(productCartLogic!!.deleteProductCart(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("modifyQuantity")
    fun createProductCart(@RequestParam id: Long, @RequestParam newQuantity: Double) : ResponseEntity<Double> {
        return try {
            ResponseEntity(productCartLogic!!.modifyQuantity(id,  newQuantity), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("list")
    fun list(): ResponseEntity<List<ProductCart>>{
        return try {
            ResponseEntity(productCartLogic!!.list(), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}