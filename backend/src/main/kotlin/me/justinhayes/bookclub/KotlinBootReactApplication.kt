package me.justinhayes.bookclub

import me.justinhayes.bookclub.domain.BookUser
import me.justinhayes.bookclub.domain.Bookshelf
import me.justinhayes.bookclub.repository.BookUserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class KotlinBootReactApplication {
    @Bean
    open fun init(repository: BookUserRepository) = CommandLineRunner {
        val bookshelf = Bookshelf()
        val user = BookUser("admin@example.com", "admin", bookshelf = bookshelf)
        repository.save(user)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinBootReactApplication::class.java, *args)
}
