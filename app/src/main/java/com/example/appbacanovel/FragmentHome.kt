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
        val parent_list = data_parent()
        val parent_adapter = ParentAdapter(parent_list)
        parent_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        parent_recycler_view.adapter = parent_adapter
        return view

    }
    fun data_parent(): List<Parent> {
        val isi_parent = mutableListOf<Parent>()

        val isi_child1 = mutableListOf<Child>()
        isi_parent.add(Parent("Rekomendasi Untuk Hari Ini", isi_child1))
        isi_child1.add(Child(R.drawable.cover1, "Judul Novel 1"))
        isi_child1.add(Child(R.drawable.cover2, "Judul Novel 2"))
        isi_child1.add(Child(R.drawable.cover3, "Judul Novel 3"))
        isi_child1.add(Child(R.drawable.cover4, "Judul Novel 4"))
        isi_child1.add(Child(R.drawable.cover5, "Judul Novel 5"))

        val isi_child2 = mutableListOf<Child>()
        isi_parent.add(Parent("Terpopuler", isi_child2))
        isi_child2.add(Child(R.drawable.cover1, "Judul Novel 1"))
        isi_child2.add(Child(R.drawable.cover2, "Judul Novel 2"))
        isi_child2.add(Child(R.drawable.cover3, "Judul Novel 3"))
        isi_child2.add(Child(R.drawable.cover4, "Judul Novel 4"))
        isi_child2.add(Child(R.drawable.cover5, "Judul Novel 5"))

        return isi_parent
    }
}