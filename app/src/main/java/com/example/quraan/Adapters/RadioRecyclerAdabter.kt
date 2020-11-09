package com.example.quraan.Adapters

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quraan.ApiManager.Model.RadioChannel
import com.example.quraan.R

public class RadioRecyclerAdabter() :RecyclerView.Adapter<RadioRecyclerAdabter.ViewHolder>() {

    var channels = listOf<RadioChannel?>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radio, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return channels.size
    }

    fun changeDate(data: List<RadioChannel?>) {
        this.channels = data
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(pos: Int, item: String)
    }

    var onItemClickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.title.setText(channels.get(position)?.name)

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView
        lateinit var play: ImageView
        lateinit var stop: ImageView


        init {
            title = itemView.findViewById(R.id.channel_name)
            play = itemView.findViewById(R.id.play)
            stop = itemView.findViewById(R.id.stop )

        }
    }
}


