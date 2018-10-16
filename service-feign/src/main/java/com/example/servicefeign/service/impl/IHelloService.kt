package com.example.servicefeign.service.impl

import com.example.servicefeign.service.HelloService
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value="eureka-client", fallback = HelloService::class)
interface IHelloService {

    @GetMapping(value = "/hi")
    fun hello(@RequestParam(name = "name") name: String): String
}