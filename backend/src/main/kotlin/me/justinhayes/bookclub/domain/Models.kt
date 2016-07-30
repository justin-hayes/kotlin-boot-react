package me.justinhayes.bookclub.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
data class Book(
        @Id val isbn: String = "",
        val title: String = "",
        @ElementCollection(targetClass = String::class) val authors: List<String> = mutableListOf(),
        val publisher: String = "",
        val publishedDate: String = "",
        val description: String = "",
        val pageCount: Int = 0,
        @ElementCollection(targetClass = String::class) val categories: List<String> = mutableListOf(),
        val language: String = "",
        val coverUrl: String = "")

@Entity
class Bookshelf(@Id @GeneratedValue val id: Long = 0,
                     @OneToMany
                     val books: List<Book> = listOf())

@Entity
class BookUser(
        @Id val email: String = "",
        val password: String = "",
        val firstname: String = "",
        val lastname: String = "",
        @OneToOne(cascade = arrayOf(CascadeType.ALL)) val bookshelf: Bookshelf = Bookshelf())

class BookUserDetails(val user: BookUser): UserDetails {
    override fun getUsername() = user.email

    override fun isCredentialsNonExpired() = true

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun getAuthorities() = AuthorityUtils.createAuthorityList("ROLE_USER")
    override fun isEnabled(): Boolean = true;

    override fun getPassword() = user.password
}