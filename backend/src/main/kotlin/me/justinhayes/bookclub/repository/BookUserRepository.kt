package me.justinhayes.bookclub.repository

import me.justinhayes.bookclub.domain.BookUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookUserRepository : CrudRepository<BookUser, String>