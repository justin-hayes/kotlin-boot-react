package me.justinhayes.api

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController() {
    private val LOGGER: Logger = LoggerFactory.getLogger(this.javaClass);

    @RequestMapping("/api/hello")
    fun sayHello(): String {
        LOGGER.info("saying hello")
        return "Hello world!"
    }
}