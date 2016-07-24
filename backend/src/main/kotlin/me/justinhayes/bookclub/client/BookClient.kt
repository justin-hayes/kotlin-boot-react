package me.justinhayes.bookclub.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import me.justinhayes.bookclub.domain.Book
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients

interface BookClient {
    val client: CloseableHttpClient
        get() = HttpClients.createDefault()

    val mapper: ObjectMapper
            get() = ObjectMapper().registerModule(KotlinModule())
    
    fun getBookByIsbn(isbn: String): Book

    fun findCoverForBook(isbn: String): String? {
        val coverUrl = "http://covers.openlibrary.org/b/isbn/${isbn}-L.jpg"
        val response = client.execute(HttpGet(coverUrl))
        if (response.statusLine.statusCode == HttpStatus.SC_OK) return coverUrl else return null
    }
}