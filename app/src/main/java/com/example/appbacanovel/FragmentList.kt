package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentList : Fragment() {

    private lateinit var novelRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        novelRecyclerView = view.findViewById(R.id.rv_list)
        novelRecyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(requireContext())

        novelRecyclerView.adapter = NovelAdapter(
            itemList = BookData.getBookList(),
            mode = NovelAdapter.NovelMode.list_page
        ) { selectedBook ->
            val intent = Intent(requireContext(), BookDetailsActivity::class.java)
            intent.putExtra("book_id", selectedBook.id)
            startActivity(intent)
        }
        return view
    }

}



