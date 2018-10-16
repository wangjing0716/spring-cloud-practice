package com.example.serviceribbon.service

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject


@Service
open class HelloService {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @HystrixCommand(fallbackMethod = "hiError")
    fun hiService(name: String): String {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=$name", String::class) ?: "sb"
    }

    fun hiError(name: String): String {
        return "hi,$name,error"
    }


}