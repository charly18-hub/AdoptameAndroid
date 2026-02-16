package com.example.adoptame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adoptame.Modal.ModalEventos
import com.example.adoptame.R

class RecyclerAdapterEventos (
// on below line we are passing variables
// as course list and context
private val eventosList: ArrayList<ModalEventos>,
private val context: Context
) : RecyclerView.Adapter<RecyclerAdapterEventos.EventosViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterEventos.EventosViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_eventos,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return EventosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterEventos.EventosViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.nameEvento.text = eventosList.get(position).nameEvento
        Glide.with(holder.itemView.context)
            .load(eventosList.get(position).courseImg)
            .centerCrop()
            .into(holder.imgEvento)
        //holder.imgEvento.setImageResource(eventosList.get(position).courseImg)
        holder.locationEvento.text = eventosList.get(position).location
        holder.dateEvent.text = eventosList.get(position).date
        //holder.petsEvent.text = eventosList.get(position).pets
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return eventosList.size
    }

    class EventosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val nameEvento: TextView = itemView.findViewById(R.id.tvTitle)
        val imgEvento: ImageView = itemView.findViewById(R.id.eventImage)
        var locationEvento: TextView = itemView.findViewById(R.id.tvLocation)
        var dateEvent: TextView = itemView.findViewById(R.id.tvDate)
        //var petsEvent: TextView = itemView.findViewById(R.id.tvPets)
       }
}