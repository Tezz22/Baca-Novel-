package com.example.appbacanovel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSearch : Fragment() {
    private lateinit var rv_search: RecyclerView
    private lateinit var btn_searching: ImageView
    private lateinit var et_search: EditText
    private lateinit var adapter: NovelAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        et_search = view.findViewById(R.id.et_search)
        btn_searching = view.findViewById(R.id.btn_searching)
        rv_search = view.findViewById(R.id.rv_search)

        adapter = NovelAdapter(
            itemList = BookData.getBookList(),
            mode = NovelAdapter.NovelMode.search_page
        )

        rv_search.layoutManager = LinearLayoutManager(requireContext())
        rv_search.adapter = adapter

        btn_searching.setOnClickListener {
            searching_action()
        }

        return view
    }

    private fun searching_action() {
        val searchText = et_search.text.toString().trim()
        val fullBookList = BookData.getBookList()

        // Filter daftar buku berdasarkan teks pencarian
        // 'ignoreCase = true' membuat pencarian tidak membedakan huruf besar/kecil
        val filteredList = if (searchText.isEmpty()) {
            fullBookList // Jika input kosong, tampilkan lagi semua buku
        } else {
            fullBookList.filter { book ->
                book.title.contains(searchText, ignoreCase = true)
            }
        }
        adapter.update_data(filteredList)
    }
}