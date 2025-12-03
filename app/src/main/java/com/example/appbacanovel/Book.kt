package com.example.appbacanovel

data class Book(
    val id: Int,
    val title : String,
    val author : String,
    val status : String? = null,
    val synopsis : String,
    val isi: String,
    val cover : Int
)