package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentFavorite : Fragment() {

    private lateinit var favoriteRecyclerView: RecyclerView // MENAMPILKAN DAFTAR BUKU bentuk e list iso discroll

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        favoriteRecyclerView = view.findViewById(R.id.rv_favorite)
        favoriteRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        loadFavoriteBooks()

        return view
    }

    override fun onResume() {
        super.onResume()
        loadFavoriteBooks() // refresh saat kembali dari halaman lain otomatis di perbarui
    }

    private fun loadFavoriteBooks() {
        val favIds = ButtonFavoriteManager.getFavorites(requireContext()) // mengambil buku yang sudah ditandai favorit

        val favoriteBooks = BookData.getBookList() // mengambil yang hanya buku tanda favorit
            .filter { favIds.contains(it.id.toString()) }
            .toMutableList()

        favoriteRecyclerView.adapter = NovelAdapter( // menampilkan buku fafvorit
            itemList = favoriteBooks,
            mode = NovelAdapter.NovelMode.favorite_page
        ) { selectedBook -> // jika di klik buku fav bakal masuk ke halaman detail
            val intent = Intent(requireContext(), BookDetailsActivity::class.java)
            intent.putExtra("book.id", selectedBook.id)
            startActivity(intent)
        }
    }

}
