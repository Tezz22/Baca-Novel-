package com.example.appbacanovel

data class Book(
    val id: Int,
    val title : String,
    val author : String,
    val status : String? = null,
    val isi: String,
    val cover : Int
)