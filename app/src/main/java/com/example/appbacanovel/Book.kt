package com.example.appbacanovel
enum class genre {
    FICTION,
    NON_FICTION,
    COMIC,
    SCIENCE,
    HISTORY,
    ROMANCE,
}

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val sinopsis: String,
    val isi: String,
    val cover: Int,
    val penerbit: String,
    val tahun_terbit: String,
    var status: Long,
    val genre: genre
)
