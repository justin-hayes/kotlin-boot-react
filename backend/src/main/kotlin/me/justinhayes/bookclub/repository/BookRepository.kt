package me.justinhayes.bookclub.repository

import me.justinhayes.bookclub.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, String>