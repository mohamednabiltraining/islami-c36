package com.route.islamic36.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.R

class VersesAdapter :RecyclerView.Adapter<VersesAdapter.viewHolder>(){
    var item:List<String>?=null

    fun changeData(verses:List<String>){
        this.item = verses
        notifyDataSetChanged()
    }

    class  viewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val content:TextView = itemView.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_verse,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val content:String? = item?.get(position)
        holder.content.setText(content)
    }

    override fun getItemCount(): Int {
        return item?.size?:0;
    }
}