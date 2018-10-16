package com.example.serviceribbon.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import com.example.serviceribbon.service.HelloService
import org.springframework.beans.factory.annotation.Autowired



@RestController
class HelloController {
    @Autowired
    private lateinit var helloService: HelloService

    @GetMapping(value = "/hi")
    fun hi(@RequestParam name: String): String {
        return helloService.hiService(name)
    }

}