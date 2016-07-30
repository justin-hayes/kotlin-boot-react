package me.justinhayes.bookclub.config

import me.justinhayes.bookclub.repository.BookUserRepository
import me.justinhayes.bookclub.service.BookUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var repository: BookUserRepository

    override fun configure(http: HttpSecurity) {
        http
            .httpBasic()
        .and()
            .authorizeRequests()
            .antMatchers("/api/**").hasRole("USER").and()
            .csrf().disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(BookUserDetailsService(repository))
    }
}
