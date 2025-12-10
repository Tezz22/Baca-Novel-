package com.example.appbacanovel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentHome : Fragment() {
    private lateinit var parent_recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        parent_recycler_view = view.findViewById(R.id.rv_home)
        parent_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        val parentList = listOf(
            Parent("Rekomendasi Untuk Hari Ini", BookData.getBookList().shuffled().take(6)),
            Parent("Novel Populer", BookData.getBookList().shuffled().take(6)),
            Parent("Novel Terbaru", BookData.getBookList().shuffled().take(6)),
            Parent("Novel Fiksi ", BookData.getBookByGenre(genre.FICTION).take(6)),
            Parent("Novel Non-Fiksi", BookData.getBookByGenre(genre.NON_FICTION).take(6)),
            Parent("Komik", BookData.getBookByGenre(genre.COMIC).take(6))
        )

        val parentAdapter = ParentAdapter(parentList)
        parent_recycler_view.adapter = parentAdapter
        return view
    }
}