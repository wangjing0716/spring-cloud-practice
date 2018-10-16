package com.example.servicehi.controller

import brave.sampler.Sampler
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@RestController
class HelloController{

    private val logger = LoggerFactory.getLogger(HelloController::class.java)

    @Autowired
    private lateinit var restTemplate: RestTemplate


    @Bean
    fun getRestTemplate() : RestTemplate {
        return RestTemplate()
    }

    @GetMapping("/hi")
    fun hi(): String? {
        logger.debug("calling trace service-hi")
        return restTemplate.getForObject("http://localhost:8092/miya", String::class)
    }

    @GetMapping("/info")
    fun info(): String {
        logger.debug("calling trace service-hi")
        return "i am service-hi"
    }

    @Bean
    fun defaultSampler(): Sampler {
        return Sampler.ALWAYS_SAMPLE
    }

}