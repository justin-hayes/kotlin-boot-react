package me.justinhayes.bookclub.client.google

import me.justinhayes.bookclub.domain.Book
import com.fasterxml.jackson.module.kotlin.*
import me.justinhayes.bookclub.client.BookClient
import me.justinhayes.bookclub.exception.BookNotFoundException
import org.apache.http.client.methods.HttpGet
import org.apache.http.util.EntityUtils
import org.springframework.stereotype.Component

@Component
open class GoogleBookClient : BookClient {
    private val urlTemplate = "https://www.googleapis.com/books/v1/volumes?q=isbn:%s"

    override fun getBookByIsbn(isbn: String): Book {
        val bookRequest = HttpGet(urlTemplate.format(isbn))
        val response = client.execute(bookRequest)
        val jsonString = EntityUtils.toString(response.entity)
        val volumes = mapper.readValue<Volumes>(jsonString)

        val volumeInfo = volumes.items?.first()?.volumeInfo ?: throw BookNotFoundException()

        return GoogleToDomainMapper.convertToDomain(volumeInfo)
    }
}