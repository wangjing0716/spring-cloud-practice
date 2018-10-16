package com.example.eurekaclient.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Value("\${server.port}")
    private lateinit var port: String

    @GetMapping("/hi")
    fun hello(@RequestParam(name = "name", defaultValue = "Jinny") name: String): String {
        return "hi,$name,port=$port"
    }
}