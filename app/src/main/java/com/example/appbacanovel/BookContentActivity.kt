package com.example.appbacanovel

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class BookContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_content)

        val book_id = intent.getIntExtra("book_id", -1)
        val book = BookData.getBookList().find { it.id == book_id }
        if (book != null) {
            findViewById<TextView>(R.id.tvJudul).text = book.title
            findViewById<TextView>(R.id.tvAuthor).text = book.author
            findViewById<TextView>(R.id.tvIsiCerita).text = book.isi
            findViewById<ImageView>(R.id.imgCover).setImageResource(book.cover)
        }
    }
}