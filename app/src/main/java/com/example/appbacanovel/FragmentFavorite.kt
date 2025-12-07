package com.example.appbacanovel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FragmentFavorite : Fragment() {

    private lateinit var favorite_recycler_view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        favorite_recycler_view = view.findViewById(R.id.rv_favorite)

        favorite_recycler_view.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(requireContext())

        favorite_recycler_view.adapter = NovelAdapter(
            itemList = BookData.getBookList() as MutableList<Book>,
            mode = NovelAdapter.NovelMode.favorite_page
        ){ selectedBook ->
            val intent = Intent ( requireContext(), BookDetailsActivity::class.java)
            intent.putExtra("book.id", selectedBook.id)
            startActivity(intent)
        }
        return view
    }
}