package me.justinhayes.bookclub.domain

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book(@Id val isbn: String = "",
                val title: String = "",
                @ElementCollection(targetClass=String::class) val authors: List<String> = mutableListOf(),
                val publisher: String = "",
                val publishedDate: String = "",
                val description: String = "",
                val pageCount: Int = 0,
                @ElementCollection(targetClass=String::class) val categories: List<String> = mutableListOf(),
                val language: String = "",
                val coverUrl: String = "")