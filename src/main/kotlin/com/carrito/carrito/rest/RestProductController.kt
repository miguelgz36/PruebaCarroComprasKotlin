package com.carrito.carrito.rest

import com.carrito.carrito.logic.IProductLogic
import com.carrito.carrito.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("products")
class RestProductController {

    @Autowired
    val productLogic: IProductLogic? = null

    @GetMapping("list/{page}/{size}")
    fun list(@PathVariable("page") page: Int, @PathVariable("size") size: Int): ResponseEntity<List<Product>>{
        return try {
            ResponseEntity(productLogic!!.list(page, size), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}