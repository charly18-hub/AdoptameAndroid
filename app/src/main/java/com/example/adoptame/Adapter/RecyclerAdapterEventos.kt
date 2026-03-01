package com.example.adoptame.Adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adoptame.Modal.ModalEventos
import com.example.adoptame.R
import com.facebook.shimmer.ShimmerFrameLayout


class RecyclerAdapterEventos (
// on below line we are passing variables
// as course list and context
private val eventosList: ArrayList<ModalEventos>,
private val context: Context
) : RecyclerView.Adapter<RecyclerAdapterEventos.EventosViewHolder>() {

    internal var isLoading = true

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterEventos.EventosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_eventos,
            parent, false
        )
        return EventosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterEventos.EventosViewHolder, position: Int) {

        if (isLoading) {
            holder.shimmer.visibility = View.VISIBLE
            holder.card.visibility = View.GONE
            holder.shimmer.startShimmer()
        } else {
            holder.shimmer.stopShimmer()
            holder.shimmer.visibility = View.GONE
            holder.card.visibility = View.VISIBLE

            val item = eventosList[position]
            holder.nameEvento.text = eventosList.get(position).nameEvento
            holder.locationEvento.text = item.location
            holder.dateEvent.text = item.date
            holder.imgEvento.setImageResource(item.courseImg)
        }
    }

    override fun getItemCount(): Int {
        return if (isLoading) 6 else eventosList.size

    }

    class EventosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shimmer: ShimmerFrameLayout = itemView.findViewById(R.id.shimmerLayoutEventos)
        val card: View = itemView.findViewById(R.id.cardReal)

        val nameEvento: TextView = itemView.findViewById(R.id.tvTitle)
        val imgEvento: ImageView = itemView.findViewById(R.id.eventImage)
        var locationEvento: TextView = itemView.findViewById(R.id.tvLocation)
        var dateEvent: TextView = itemView.findViewById(R.id.tvDate)
        //var petsEvent: TextView = itemView.findViewById(R.id.tvPets)
       }
}