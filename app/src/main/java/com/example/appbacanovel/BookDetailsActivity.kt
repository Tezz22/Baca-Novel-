package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_details)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBookmark = findViewById<ImageView>(R.id.btnBookmark)
        val btnShare = findViewById<ImageView>(R.id.btnShare)
        val btnBaca = findViewById<TextView>(R.id.btnBaca)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRekomendasi)
        val listRekomendasi = listOf(
            R.drawable.cover1,
            R.drawable.cover2,
            R.drawable.cover3,
            R.drawable.cover4,
            R.drawable.cover5
        )

        val book_id = intent.getIntExtra("book_id", -1)
        val book = BookData.getBookList().find { it.id == book_id }
        if (book != null) {
            findViewById<TextView>(R.id.txtJudul).text = book.title
            findViewById<TextView>(R.id.txtAuthor).text = book.author
            findViewById<TextView>(R.id.txtPenerbit).text = book.penerbit
            findViewById<TextView>(R.id.txtTahun).text = book.tahun_terbit
            findViewById<TextView>(R.id.txtTipe).text = book.tipe
            findViewById<TextView>(R.id.txtSinopsis).text = book.synopsis
            findViewById<ImageView>(R.id.imgCover).setImageResource(book.cover)
        }

        btnBaca.setOnClickListener {
            val intent = Intent(this, BookContentActivity::class.java)
            intent.putExtra("book_id", book_id)
            startActivity(intent)
        }

        btnBookmark.setOnClickListener {

        }

        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Saya membaca novel ${book?.title} dari Novelia")
            startActivity(Intent.createChooser(intent, "Bagikan melalui"))
        }

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = RekomendasiAdapter(listRekomendasi)
    }
}
