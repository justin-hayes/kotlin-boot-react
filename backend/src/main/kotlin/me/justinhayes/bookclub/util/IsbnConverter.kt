package me.justinhayes.bookclub.web

import me.justinhayes.bookclub.exception.InvalidIsbnException

private fun String.isValidIsbn10(): Boolean {
    if (this.length != 10) return false
    try {this.toInt()} catch (ex: NumberFormatException) { return false }

    val checkDigit = (11 - this.dropLast(1).foldIndexed(0) {i, acc, c ->
        acc + c.toNumeric() * (10 - i)
    } % 11) % 11

    return this.last().toString() == checkDigit.toString()
}

private fun String.isValidIsbn13(): Boolean {
    if (this.length != 13) return false
    try {this.toInt()} catch (ex: NumberFormatException) { return false }

    val checkDigit = getIsbn13CheckDigit(this.dropLast(1))

    return this.last().toString() == checkDigit.toString()
}

private fun getIsbn13CheckDigit(partialIsbn: String): Int {
  return (10 - (partialIsbn.foldIndexed(0) {i, acc, c ->
        if (i % 2 != 0) {
            acc + c.toNumeric() * 3
        } else {
            acc + c.toNumeric()
        }
    }) % 10)
}

private fun isbn10to13(isbn: String): String {
    val baseIsbn = "978" + isbn.dropLast(1)
    val checkDigit = getIsbn13CheckDigit(baseIsbn)

    return baseIsbn + checkDigit
}

fun String.toIsbn13(): String {
    return when {
        this.isValidIsbn13() -> this
        this.isValidIsbn10() -> isbn10to13(this)
        else -> throw InvalidIsbnException()
    }
}

fun Char.toNumeric(): Int {
    return Character.getNumericValue(this)
}