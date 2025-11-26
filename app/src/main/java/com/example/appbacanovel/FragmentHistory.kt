package com.example.appbacanovel

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

        val history_list = data_history()
        val history_adapter = HistoryAdapter(history_list)
        history_recycler_view.adapter = history_adapter

        return view
    }

    fun data_history(): List<History> {
        val isi_history = mutableListOf<History>()
        isi_history.add(History(R.drawable.cover1, "Judul Novel 1", "Author Novel 1", "Terakhir dibaca 2 hari lalu"))
        isi_history.add(History(R.drawable.cover2, "Judul Novel 2", "Author Novel 2", "Terakhir dibaca 2 hari lalu"))
        isi_history.add(History(R.drawable.cover3, "Judul Novel 3", "Author Novel 3", "Terakhir dibaca 2 hari lalu"))
        isi_history.add(History(R.drawable.cover4, "Judul Novel 4", "Author Novel 4", "Terakhir dibaca 2 hari lalu"))
        isi_history.add(History(R.drawable.cover5, "Judul Novel 5", "Author Novel 5", "Terakhir dibaca 2 hari lalu"))
        return isi_history
    }
}