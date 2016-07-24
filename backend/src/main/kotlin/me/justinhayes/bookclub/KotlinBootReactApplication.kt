package me.justinhayes.bookclub

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotlinBootReactApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinBootReactApplication::class.java, *args)
}
