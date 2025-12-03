package com.example.appbacanovel

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentAdapter(
    private val parentList: List<Parent>
    ) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parentTitle: TextView = itemView.findViewById(R.id.tv_title_home)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.rv_child)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_home_rv, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parentItem = parentList[position]
        holder.parentTitle.text = parentItem.title
        holder.childRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.childRecyclerView.adapter = NovelAdapter(
            itemList = parentItem.children,
            mode = NovelAdapter.NovelMode.home_page
        ) { selectedBook ->
            val intent = Intent(holder.itemView.context, BookDetailsActivity::class.java)
            intent.putExtra("book_id", selectedBook.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return parentList.size
    }
}
