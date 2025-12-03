package com.example.appbacanovel

import android.content.Intent
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
            Parent("Novel Populer", BookData.getBookList()),
            Parent("Novel Terbaru", BookData.getBookList())
        )

        val parentAdapter = ParentAdapter(parentList)
        parent_recycler_view.adapter = parentAdapter
        return view
    }
}