package me.justinhayes.bookclub.repository

import me.justinhayes.bookclub.domain.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, String>