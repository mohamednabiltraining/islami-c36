package com.route.islamic36.home.hadeth.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.R


class HadethNameAdapter(val items: List<String>) :
    RecyclerView.Adapter<HadethNameAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_name, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val hadethname = items.get(position)
        holder.name.setText(hadethname)
        if (OnItemClicklistener != null) {
            holder.itemView.setOnClickListener {
                OnItemClicklistener?.onItemClick(position, hadethname)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    var OnItemClicklistener: onItemClicklistener? = null

    interface onItemClicklistener {
        fun onItemClick(position: Int, name: String)
    }

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.item_hadeth_name)
    }


}