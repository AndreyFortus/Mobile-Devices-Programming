package com.example.lab_8

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HorizontalAdapter (
    private val mList: List<ItemsViewModel>,
    private val onItemClick:(position:Int)->Unit
): RecyclerView.Adapter<HorizontalAdapter.ViewHolder>(){

    class ViewHolder(internal val itemViewH: View,
                     private val onItemClick: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(itemViewH) {

        init{
            itemView.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                onItemClick(position)
            }
        }
        val imageView: ImageView = itemView.findViewById(R.id.itemImage)
        val imageViewSecond: ImageView = itemView.findViewById(R.id.itemImage2)
        val textView: TextView = itemView.findViewById(R.id.itemText)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_card_view_design, parent, false)

        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]

        Glide.with(holder.itemView.context)
            .load(itemsViewModel.image)
            .into(holder.imageView)

        Glide.with(holder.itemView.context)
            .load(itemsViewModel.image)
            .into(holder.imageViewSecond)

        holder.textView.text = itemsViewModel.text
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
