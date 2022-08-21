package com.route.islamic36.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.R

class SuraNameAdapter(val items:List<String>) : RecyclerView.Adapter<SuraNameAdapter.ViewHolder>(){

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val name:TextView = itemView.findViewById(R.id.chapter_name_label)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chapter_name,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = items[position]
        holder.name.text = (suraName)

        onitemClickListener?.let {
            holder.itemView.setOnClickListener{
                onitemClickListener?.onItemClick(position,suraName)
            }
        }
    }

    var onitemClickListener : onItemClickListener? = null

    interface onItemClickListener {
        fun onItemClick(pos:Int,item:String)
    }

    override fun getItemCount(): Int = items.size

}