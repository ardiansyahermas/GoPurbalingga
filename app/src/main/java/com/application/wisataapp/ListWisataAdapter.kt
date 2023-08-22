package com.application.wisataapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ListWisataAdapter(private val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_wisata, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListWisataAdapter.ListViewHolder, position: Int) {
        val wisata = listWisata[position]

        wisata.photo?.let {
            Picasso.with(holder.itemView.context)
                .load(it)
                .resize(50, 50)
                .into(holder.imgPhoto)
        }

        holder.tvPlace.text = wisata.place
        holder.tvLocation.text = wisata.location
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClickedData(listWisata[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listWisata.size
    }

    interface OnItemClickCallback {
        fun onItemClickedData(data: Wisata)
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPlace: TextView = itemView.findViewById(R.id.tv_item_place)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }
}