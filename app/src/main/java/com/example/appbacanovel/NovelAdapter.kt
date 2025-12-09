package com.example.appbacanovel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date



class NovelAdapter (
    private var itemList: MutableList<Book>,
    private val mode: NovelMode,
    private val onItemClick: (Book) -> Unit
    ) : RecyclerView.Adapter<NovelAdapter.NovelViewHolder>() {
    enum class NovelMode{
        home_page,
        list_page,
        history_page,
        favorite_page,
        search_page,
        rekom_book_detail
    }
    class NovelViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NovelAdapter.NovelViewHolder {
        val layoutId = when(mode) {
            NovelMode.home_page -> R.layout.item_child
            NovelMode.list_page -> R.layout.item_child
            NovelMode.history_page -> R.layout.item_history
            NovelMode.favorite_page -> R.layout.item_favorite
            NovelMode.search_page -> R.layout.item_search
            NovelMode.rekom_book_detail -> R.layout.item_child
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return NovelViewHolder(view)

    }

    override fun onBindViewHolder(holder: NovelAdapter.NovelViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.view.setOnClickListener {
            onItemClick(currentItem)
        }

        when(mode) {
            NovelMode.home_page -> bindHome(holder.view, currentItem)
            NovelMode.list_page -> bindList(holder.view, currentItem)
            NovelMode.history_page -> bindHistory(holder.view, currentItem)
            NovelMode.favorite_page -> bindFavorite(holder.view, currentItem)
            NovelMode.search_page -> bindSearch(holder.view, currentItem)
            NovelMode.rekom_book_detail -> bindRekom(holder.view, currentItem)

        }
    }

    override fun getItemCount() : Int {
        return itemList.size
    }

    private fun adapterPosition(view: View): Int {
        return (view.parent as? RecyclerView)?.getChildAdapterPosition(view) ?: -1
    }

    private fun bindRekom(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_child_home)
        val title = view.findViewById<TextView>(R.id.tv_book_title)

        image.setImageResource(item.cover)
        title.text = item.title
    }

    private fun bindHome(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_child_home)
        val title = view.findViewById<TextView>(R.id.tv_book_title)
        image.setImageResource(item.cover)
        title.text = item.title
    }

    private fun bindList(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_child_home)
        val title = view.findViewById<TextView>(R.id.tv_book_title)

        image.setImageResource(item.cover)
        title.text = item.title
    }

    private fun bindHistory(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_history_cover)
        val title = view.findViewById<TextView>(R.id.tv_history_title)
        val author = view.findViewById<TextView>(R.id.tv_history_author)
        val status = view.findViewById<TextView>(R.id.tv_history_status)

        val date = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
        val formattedDate = date.format(Date(item.status))

        image.setImageResource(item.cover)
        title.text = item.title
        author.text = item.author
        status.text = "Terakhir dibaca: $formattedDate"
    }


    private fun bindFavorite(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_fav_cover)
        val title = view.findViewById<TextView>(R.id.tv_fav_title)
        val author = view.findViewById<TextView>(R.id.tv_fav_author)
        val btnRemove = view.findViewById<ImageButton>(R.id.btn_favorite_remove)

        image.setImageResource(item.cover)
        title.text = item.title
        author.text = item.author

        btnRemove.setOnClickListener {
            // HAPUS dari SharedPreferences
            ButtonFavoriteManager.removeFavorite(view.context, item.id)

            // HAPUS dari RecyclerView
            val pos = adapterPosition(view)
            if (pos != -1 && pos < itemList.size) {
                itemList.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }
    }


    private fun bindSearch(view: View, item: Book) {
        val image = view.findViewById<ImageView>(R.id.iv_search_cover)
        val title = view.findViewById<TextView>(R.id.tv_search_title)
        val author = view.findViewById<TextView>(R.id.tv_search_author)
        val status = view.findViewById<TextView>(R.id.tv_search_genre)
        image.setImageResource(item.cover)
        title.text = item.title
        author.text = item.author
        status.text = item.genre.name
    }

    fun update_data(new_data: MutableList<Book>) {
        itemList = new_data
        notifyDataSetChanged()
    }
}