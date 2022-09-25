package com.route.islamic36.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.R

class SoraNamesAdapter(val items:List<String>): RecyclerView.Adapter<SoraNamesAdapter.ViewHolder>() {


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name:TextView = itemView.findViewById(R.id.sora_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sora_name,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = items.get(position)
        holder.name.setText(suraName)
        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener{
                onItemClickListener?.onItemClick(position,suraName)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    var onItemClickListener: OnItemClickListener? =null

    interface OnItemClickListener{
        fun onItemClick(pos:Int,name:String)
    }
}