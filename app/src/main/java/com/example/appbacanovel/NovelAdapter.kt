package com.example.appbacanovel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NovelAdapter (
    private val itemList: List<Book>,
    private val mode: NovelMode
    ) : RecyclerView.Adapter<NovelAdapter.NovelViewHolder>() {
    enum class NovelMode{
        home_page,
        list_page,
        history_page,
        favorite_page
    }
    class NovelViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NovelAdapter.NovelViewHolder {
        val view = when(mode) {
            NovelMode.home_page -> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_child, parent, false)

            NovelMode.list_page -> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)

            NovelMode.history_page -> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history, parent, false)

            NovelMode.favorite_page -> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_favorite, parent, false)
        }
        return NovelViewHolder(view)
    }

    override fun onBindViewHolder(holder: NovelAdapter.NovelViewHolder, position: Int) {
        val currentItem = itemList[position]

        when(mode) {
            NovelMode.home_page -> bindHome(holder.view, currentItem)
            NovelMode.list_page -> bindList(holder.view, currentItem)
            NovelMode.history_page -> bindHistory(holder.view, currentItem)
            NovelMode.favorite_page -> bindFavorite(holder.view, currentItem)
        }
    }

    override fun getItemCount() : Int {
        return itemList.size
    }


    private fun bindHome(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_child_home)
        val title = view.findViewById<TextView>(R.id.tv_book_title)
        image.setImageResource(item.cover)
        title.text = item.title
    }

    private fun bindList(view: View, item: Book) {

    }

    private fun bindHistory(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_child_home)
        val title = view.findViewById<TextView>(R.id.tv_history_title)
        val author = view.findViewById<TextView>(R.id.tv_history_author)
        val status = view.findViewById<TextView>(R.id.tv_history_status)
        image.setImageResource(item.cover)
        title.text = item.title
        author.text = item.author
        status.text = item.status
    }

    private fun bindFavorite(view: View, item: Book) {

    }

}