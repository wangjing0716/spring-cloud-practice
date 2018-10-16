package com.example.servicefeign.controller

import com.example.servicefeign.service.impl.IHelloService
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@RestController
class HelloController {

    @Autowired
    private lateinit var helloService: IHelloService

    @GetMapping("/hi")
    fun hello(@RequestParam name: String) : String {
        return helloService.hello(name)
    }
}