package com.example.appbacanovel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentHistory : Fragment() {
    private lateinit var history_recycler_view: RecyclerView
    private lateinit var adapter: NovelAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        history_recycler_view = view.findViewById(R.id.rv_history)
        history_recycler_view.layoutManager = LinearLayoutManager(requireContext())

        val historyList = HistoryManager.getHistoryBooks(requireContext())

        adapter = NovelAdapter(
            itemList = historyList,
            mode = NovelAdapter.NovelMode.history_page
        ) { selectedBook ->
            val intent = android.content.Intent(requireContext(), BookDetailsActivity::class.java)
            intent.putExtra("book_id", selectedBook.id)
            startActivity(intent)
        }

        history_recycler_view.adapter = adapter

        return view
    }

    override fun onResume() {
        super.onResume()

        val updatedHistory = HistoryManager.getHistoryBooks(requireContext())
        adapter.update_data(updatedHistory)
    }
}