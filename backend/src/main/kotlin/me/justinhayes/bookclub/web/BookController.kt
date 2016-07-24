package me.justinhayes.bookclub.web

import me.justinhayes.bookclub.domain.Book
import me.justinhayes.bookclub.exception.BookNotFoundException
import me.justinhayes.bookclub.exception.InvalidIsbnException
import me.justinhayes.bookclub.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class BookController @Autowired constructor(val bookService: BookService) {

    @RequestMapping("/api/books")
    fun getAllBooks() = bookService.getAllBooks()

    @RequestMapping("/api/books/{isbn}")
    fun getBookByIsbn(@PathVariable isbn: String): Book {
        return bookService.getBookByIsbn(isbn);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such book")
    @ExceptionHandler(BookNotFoundException::class)
    fun handleBookNotFound() {}

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIsbnException::class)
    fun handleInvalidIsbn() {}
}