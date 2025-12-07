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
    private lateinit var novelRecyclerView: RecyclerView
    private lateinit var btnBookmark: ImageView
    private lateinit var btnShare: ImageView
    private lateinit var btnBaca: TextView

    private var bookId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_details)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBookmark = findViewById(R.id.btnBookmark)
        btnShare = findViewById(R.id.btnShare)
        btnBaca = findViewById(R.id.btnBaca)
        novelRecyclerView = findViewById(R.id.recyclerRekomendasi)
        novelRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        bookId = intent.getIntExtra("book_id", -1)
        val book = BookData.getBookList().find { it.id == bookId }
        if (book != null) {
            findViewById<TextView>(R.id.txtJudul).text = book.title
            findViewById<TextView>(R.id.txtAuthor).text = book.author
            findViewById<TextView>(R.id.txtPenerbit).text = book.penerbit
            findViewById<TextView>(R.id.txtTahun).text = book.tahun_terbit
            findViewById<TextView>(R.id.txtTipe).text = book.tipe
            findViewById<TextView>(R.id.txtSinopsis).text = book.synopsis
            findViewById<ImageView>(R.id.imgCover).setImageResource(book.cover)
        }

        updateFavoriteButton()

        btnBookmark.setOnClickListener {
            ButtonFavoriteManager.addFavorite(this, bookId)
            updateFavoriteButton()
        }

        btnBaca.setOnClickListener {
            val intent = Intent(this, BookContentActivity::class.java)
            intent.putExtra("book_id", bookId)
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Saya membaca novel ${book?.title} di aplikasi Novelia.")
            startActivity(Intent.createChooser(intent, "Bagikan melalui"))
        }

        novelRecyclerView.adapter = NovelAdapter(
            itemList = BookData.getBookList() as MutableList<Book>,
            mode = NovelAdapter.NovelMode.rekom_book_detail
        ) { selectedBook ->
            val intent = Intent(this, BookDetailsActivity::class.java)
            intent.putExtra("book_id", selectedBook.id)
            startActivity(intent)
            finish()
        }
    }

    private fun updateFavoriteButton() {
        if (ButtonFavoriteManager.isFavorite(this, bookId)) {
            btnBookmark.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            btnBookmark.setImageResource(R.drawable.ic_favorite)
        }
    }
}
