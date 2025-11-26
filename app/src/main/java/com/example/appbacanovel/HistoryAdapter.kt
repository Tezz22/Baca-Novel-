package com.example.appbacanovel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter (private val itemList: List<History>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.iv_child_home)
        val title: TextView = itemView.findViewById(R.id.tv_history_title)
        val author: TextView = itemView.findViewById(R.id.tv_history_author)
        val status: TextView = itemView.findViewById(R.id.tv_history_status)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
        holder.author.text = currentItem.author
        holder.status.text = currentItem.status
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}