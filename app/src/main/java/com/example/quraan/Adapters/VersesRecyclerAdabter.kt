package com.example.quraan.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quraan.R

public class VersesRecyclerAdabter() :RecyclerView.Adapter<VersesRecyclerAdabter.ViewHolder>() {

    var versesList = listOf<String>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return versesList.size
    }

    fun changeDate(data: List<String>) {
        this.versesList = data
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(pos: Int, item: String)
    }

    var onItemClickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.setText(versesList.get(position)+ "{"+position+"}")

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var content: TextView

        init {
            content = itemView.findViewById(R.id.content)
        }
    }
}


