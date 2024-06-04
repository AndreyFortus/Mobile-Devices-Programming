package com.example.lab_10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_10.databinding.QuotesItemBinding

class QuotesAdapter(var quotesList: ArrayList<Quote>):
    RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {

    inner class QuotesViewHolder(val adapterBinding: QuotesItemBinding) : RecyclerView.ViewHolder(adapterBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val binding = QuotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.adapterBinding.textViewId.text = quotesList[position].id.toString()
        holder.adapterBinding.textViewQuote.text = quotesList[position].quote
        holder.adapterBinding.textViewAuthor.text = quotesList[position].quoteAuthor
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }
}
