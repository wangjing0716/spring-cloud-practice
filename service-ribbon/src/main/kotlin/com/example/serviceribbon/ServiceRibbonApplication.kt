package com.example.serviceribbon

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
open class ServiceRibbonApplication {
    private val logger = LoggerFactory.getLogger(ServiceRibbonApplication::class.java)

    @Bean
    @LoadBalanced
    open fun restTemplate(): RestTemplate {
        System.out.print("-----------------")
        logger.debug("===========")
        return RestTemplate()
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(ServiceRibbonApplication::class.java, *args)
}