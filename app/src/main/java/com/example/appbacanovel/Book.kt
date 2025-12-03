package com.example.appbacanovel

data class Book(
    val id: Int,
    val title : String,
    val author : String,
    val status : String,
    val synopsis : String,
    val isi: String,
    val cover : Int,
    val penerbit : String,
    val tahun_terbit : String,
    val tipe : String
)