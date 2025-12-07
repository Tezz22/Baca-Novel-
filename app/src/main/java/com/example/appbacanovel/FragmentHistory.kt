package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FragmentHistory : Fragment() {
    private lateinit var history_recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        history_recycler_view = view.findViewById(R.id.rv_history)

        history_recycler_view.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(requireContext())

        history_recycler_view.adapter = NovelAdapter(
            itemList = BookData.getBookList() as MutableList<Book>,
            mode = NovelAdapter.NovelMode.history_page
        ){ selectedBook ->
            val intent = Intent(requireContext(), BookDetailsActivity::class.java)
            intent.putExtra("book_id", selectedBook.id)
            startActivity(intent)
        }

        return view
    }


}