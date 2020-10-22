package com.carrito.carrito.rest

import com.carrito.carrito.logic.ICartLogic
import com.carrito.carrito.model.Cart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cart")
class RestCartController {

    @Autowired
    val cartLogic: ICartLogic ?= null

    @PostMapping("checkout")
    fun createProductCart(@RequestParam id: Long) : ResponseEntity<Boolean> {
        return try {
            ResponseEntity(cartLogic!!.checkOut(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("list")
    fun list(): ResponseEntity<List<Cart>>{
        return try {
            ResponseEntity(cartLogic!!.list(), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}