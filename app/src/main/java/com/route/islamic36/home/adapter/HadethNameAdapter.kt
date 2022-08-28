package com.route.islamic36.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.R

class HadethNameAdapter(val items : List<String>) : RecyclerView.Adapter<HadethNameAdapter.ViewHolder>() {

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val name:TextView = itemView.findViewById(R.id.hadeth_num)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_num,parent,false)
        return ViewHolder(view)
    }

    var onHadethSelect : onHadethClick? = null

    interface onHadethClick{
        fun onClick(pos:Int,item:String)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadethName = items[position]
        holder.name.text = hadethName

        onHadethSelect?.let {
            holder.itemView.setOnClickListener{
                onHadethSelect!!.onClick(position,hadethName)
            }
        }
    }


    override fun getItemCount(): Int = items.size
}