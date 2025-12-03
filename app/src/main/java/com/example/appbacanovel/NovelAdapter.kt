package com.example.appbacanovel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NovelAdapter (
    private var itemList: List<Book>,
    private val mode: NovelMode
    ) : RecyclerView.Adapter<NovelAdapter.NovelViewHolder>() {
    enum class NovelMode{
        home_page,
        list_page,
        history_page,
        favorite_page,
        search_page
    }
    class NovelViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NovelAdapter.NovelViewHolder {
        val layoutId = when(mode) {
            NovelMode.home_page -> R.layout.item_child
            NovelMode.list_page -> R.layout.item_list
            NovelMode.history_page -> R.layout.item_history
            NovelMode.favorite_page -> R.layout.item_favorite
            NovelMode.search_page -> R.layout.item_search
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return NovelViewHolder(view)

    }

    override fun onBindViewHolder(holder: NovelAdapter.NovelViewHolder, position: Int) {
        val currentItem = itemList[position]

        when(mode) {
            NovelMode.home_page -> bindHome(holder.view, currentItem)
            NovelMode.list_page -> bindList(holder.view, currentItem)
            NovelMode.history_page -> bindHistory(holder.view, currentItem)
            NovelMode.favorite_page -> bindFavorite(holder.view, currentItem)
            NovelMode.search_page -> bindSearch(holder.view, currentItem)
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
//        val image = view.findViewById<ImageView>(R.id.iv_list_cover)
//        val title = view.findViewById<TextView>(R.id.tv_list_title)
//        val author = view.findViewById<TextView>(R.id.tv_list_author)
//
//        image.setImageResource(item.cover)
//        title.text = item.title
//        author.text = item.author
    }

    private fun bindHistory(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_history_cover)
        val title = view.findViewById<TextView>(R.id.tv_history_title)
        val author = view.findViewById<TextView>(R.id.tv_history_author)
        val status = view.findViewById<TextView>(R.id.tv_history_status)

        image.setImageResource(item.cover)
        title.text = item.title
        author.text = item.author
        status.text = item.status
    }


    private fun bindFavorite(view: View, item: Book) {
//        val image = view.findViewById<ImageView>(R.id.iv_fav_cover)
//        val title = view.findViewById<TextView>(R.id.tv_fav_title)
//        val author = view.findViewById<TextView>(R.id.tv_fav_author)
//
//        image.setImageResource(item.cover)
//        title.text = item.title
//        author.text = item.author
    }

    private fun bindSearch(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_search_cover)
        val title = view.findViewById<TextView>(R.id.tv_search_title)
        val author = view.findViewById<TextView>(R.id.tv_search_author)
        val status = view.findViewById<TextView>(R.id.tv_search_update)
        image.setImageResource(item.cover)
        title.text = item.title
        author.text = item.author
        status.text = item.status
    }

    fun update_data(new_data: List<Book>) {
        itemList = new_data
        notifyDataSetChanged()
    }
}