package com.example.prkuliah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class AdapterEvent(private val eventlist : ArrayList<EventData>) : RecyclerView.Adapter<AdapterEvent.MyViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recomend_event,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = eventlist[position]

        holder.tvOrganizer.text = currentItem.organizer
        holder.tvKategori.text = currentItem.category
        holder.tvNamaEvent.text = currentItem.namaEvent
        holder.tvPlace.text = currentItem.place
        holder.tvSlot.text = currentItem.slot.toString()
        holder.tvPrice.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return eventlist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvOrganizer : TextView = itemView.findViewById(R.id.tvOrganizer)
        val tvKategori : TextView = itemView.findViewById(R.id.tvKategori)
        val tvNamaEvent : TextView = itemView.findViewById(R.id.tvNamaevent)
        val tvPlace : TextView = itemView.findViewById(R.id.tvPlace)
        val tvSlot : TextView = itemView.findViewById(R.id.tvSlot)
        val tvPrice : TextView = itemView.findViewById(R.id.tvPrice)
    }
}