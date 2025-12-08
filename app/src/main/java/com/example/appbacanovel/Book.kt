package com.example.appbacanovel

import java.time.LocalDate
import java.util.Date

// Enum for Book Status (e.g., Available, Borrowed, etc.)

// Enum for Book Type (e.g., Fiction, Non-Fiction, etc.)
enum class genre {
    FICTION,
    NON_FICTION,
    COMIC,
    SCIENCE,
    HISTORY,
}

// Book data class with enum integration
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val sinopsis: String,
    val isi: String,
    val cover: Int,
    val penerbit: String,
    val tahun_terbit: String,
    val status: Date,// Could be changed to an enum if you categorize years
    val genre: genre          // Using BookType enum
)
