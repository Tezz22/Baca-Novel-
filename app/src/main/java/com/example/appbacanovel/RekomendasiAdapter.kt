package com.example.appbacanovel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class RekomendasiAdapter(
    private val listCover: Novel<Int>
) : RecyclerView.Adapter<RekomendasiAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCover = itemView.findViewById<ImageView>(R.id.imgCoverItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cover_buku, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgCover.setImageResource(listCover[position])
    }

    override fun getItemCount(): Int {
        return listCover.size
    }
}
