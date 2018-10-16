package com.example.servicemiya.controller

import brave.sampler.Sampler
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


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
    fun hi(): String{
        logger.debug("hi is being called")
        return "hi i am miya"
    }

    @GetMapping("/miya")
    fun info(): String {
        logger.debug("info is being called")
        return restTemplate.getForObject("http://localhost:8091/info", String::class.java);
    }

    @Bean
    fun defaultSampler(): Sampler {
        return Sampler.ALWAYS_SAMPLE
    }

}