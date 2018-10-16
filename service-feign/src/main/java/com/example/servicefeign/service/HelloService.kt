package com.example.servicefeign.service

import com.example.servicefeign.service.impl.IHelloService
import org.springframework.stereotype.Component

@Component
class HelloService : IHelloService {
    override fun hello(name: String): String {
        return "hi,$name,error"
    }
}