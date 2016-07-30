package me.justinhayes.bookclub.service

import me.justinhayes.bookclub.domain.BookUserDetails
import me.justinhayes.bookclub.exception.UsernameNotFoundException
import me.justinhayes.bookclub.repository.BookUserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class BookUserDetailsService(val repository: BookUserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findOne(username) ?: throw UsernameNotFoundException()
        return BookUserDetails(user)
    }
}