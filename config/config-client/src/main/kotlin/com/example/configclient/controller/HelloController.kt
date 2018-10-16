package com.example.configclient.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Value("\$sb")
    private lateinit var sb: String

    @GetMapping("/hi")
    fun hi(): String {
        return sb
    }
}