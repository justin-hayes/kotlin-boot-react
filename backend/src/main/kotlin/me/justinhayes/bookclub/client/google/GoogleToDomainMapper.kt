package me.justinhayes.bookclub.client.google

import me.justinhayes.bookclub.domain.Book

class GoogleToDomainMapper {
    companion object {
        fun convertToDomain(volumeInfo: VolumeInfo): Book {
            return Book(
                    isbn = volumeInfo.industryIdentifiers.filter { it.type == "ISBN_13" }.first().identifier,
                    title = volumeInfo.title,
                    authors = volumeInfo.authors,
                    categories = volumeInfo.categories,
                    description = volumeInfo.description,
                    language = volumeInfo.language,
                    pageCount = volumeInfo.pageCount,
                    publisher = volumeInfo.publisher,
                    publishedDate = volumeInfo.publishedDate)
        }
    }
}