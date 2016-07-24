package me.justinhayes.bookclub.service

import me.justinhayes.bookclub.client.BookClient
import me.justinhayes.bookclub.domain.Book
import me.justinhayes.bookclub.repository.BookRepository
import me.justinhayes.bookclub.util.toIsbn13
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface BookService {
    fun getAllBooks(): List<Book>
    fun getBookByIsbn(isbn: String): Book
}

@Service
class BookServiceImpl @Autowired constructor(val repository: BookRepository,
                                             val client: BookClient) : BookService {

    override fun getAllBooks(): List<Book> = repository.findAll().toList()

    override fun getBookByIsbn(isbn: String): Book {
        val isbn13 = isbn.toIsbn13()
        return repository.findOne(isbn13) ?: repository.save(addCoverToBook(client.getBookByIsbn(isbn13)))
    }

    private fun addCoverToBook(book: Book): Book {
        val coverUrl = client.findCoverForBook(book.isbn);
        return if (coverUrl != null) book.copy(coverUrl = coverUrl) else book
    }
}