package me.justinhayes.bookclub.client.google

import com.fasterxml.jackson.annotation.JsonProperty

data class Volumes(
        val kind: String,
        val totalItems: Int,
        val items: List<Item>?)

data class Item(
        val kind: String,
        val id: String,
        val etag: String,
        val selfLink: String,
        val volumeInfo: VolumeInfo,
        val saleInfo: SaleInfo,
        val accessInfo: AccessInfo,
        val searchInfo: SearchInfo
)

data class VolumeInfo(
        val title: String,
        val authors: List<String>,
        val publisher: String,
        val publishedDate: String,
        val description: String,
        val industryIdentifiers: List<IndustryIdentifier>,
        val readingModes: ReadingMode,
        val pageCount: Int,
        val printType: String,
        val categories: List<String>,
        val averageRating: Double,
        val ratingsCount: Int,
        val maturityRating: String,
        val allowAnonLogging: Boolean,
        val contentVersion: String,
        val imageLinks: ImageLinks,
        val language: String,
        val previewLink: String,
        val infoLink: String,
        val canonicalVolumeLink: String
)

data class IndustryIdentifier(val `type`: String, val identifier: String)

data class ReadingMode(val text: Boolean, val image: Boolean)

data class ImageLinks(val smallThumbnail: String, val thumbnail: String)

data class SaleInfo(val country: String, val saleability: String, val isEbook: Boolean)

data class AccessInfo(
        val country: String,
        val viewability: String,
        val embeddable: Boolean,
        val publicDomain: Boolean,
        val textToSpeechPermission: String,
        val epub: BookFormat,
        val pdf: BookFormat,
        val webReaderLink: String,
        val accessViewStatus: String,
        val quoteSharingAllowed: Boolean
)


data class BookFormat(@JsonProperty("isAvailable") val isAvailable: Boolean)

data class SearchInfo(val textSnippet: String)