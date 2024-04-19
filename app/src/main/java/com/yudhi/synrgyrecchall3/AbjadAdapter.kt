package com.yudhi.synrgyrecchall3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AbjadAdapter (private val hurufList: List<String>, private val listener: (String) -> Unit)
    : RecyclerView.Adapter<AbjadAdapter.ViewHolder>(){
    class ViewHolder(itemView: View, private val listener: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val hurufTextView: TextView = itemView.findViewById(R.id.tvabjad)
        fun bind(huruf: String) {
            hurufTextView.text = huruf
            itemView.setOnClickListener { listener(huruf) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_abjad, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hurufList[position])
    }

    override fun getItemCount(): Int = hurufList.size

}