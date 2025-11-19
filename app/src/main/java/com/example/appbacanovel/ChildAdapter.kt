package com.example.appbacanovel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChildAdapter (private val itemList: List<Child>) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {
    class ChildViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv_child_home)
        val title: TextView = itemView.findViewById(R.id.tv_book_title)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_child, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ChildViewHolder, position: Int
    ) {
        val currentItem = itemList[position]

        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return itemList.size

    }
}