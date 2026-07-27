package com.example.adoptame.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adoptame.R
import com.example.adoptame.domain.entity.Events
import com.facebook.shimmer.ShimmerFrameLayout


class RecyclerAdapterEventos (
    private val eventosList: ArrayList<Events>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerAdapterEventos.EventosViewHolder>() {

    internal var isLoading = true

    fun updateList(list: List<Events>){
        eventosList.clear()
        eventosList.addAll(list)
        notifyDataSetChanged()
    }

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
        if (isLoading) {
            holder.shimmer.visibility = View.VISIBLE
            holder.card.visibility = View.GONE
            holder.shimmer.startShimmer()
        } else {
            holder.shimmer.stopShimmer()
            holder.shimmer.visibility = View.GONE
            holder.card.visibility = View.VISIBLE

            val item = eventosList[position]
            holder.nameEvento.text = item.nameEvent

            Glide.with(context)
                .load(R.drawable.adopta_anegl)
                .into(holder.imgEvento)

            holder.locationEvento.text = item.locationEvent
            holder.dateEvent.text = item.date
        }
    }

    override fun getItemCount(): Int {
        return if (isLoading) 6 else eventosList.size

    }

    class EventosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shimmer: ShimmerFrameLayout = itemView.findViewById(R.id.shimmerLayoutEventos)
        val card: View = itemView.findViewById(R.id.linearLayoutEventsReal)
        val nameEvento: TextView = itemView.findViewById(R.id.tvTitle)
        val imgEvento: ImageView = itemView.findViewById(R.id.eventImage)
        var locationEvento: TextView = itemView.findViewById(R.id.tvLocation)
        var dateEvent: TextView = itemView.findViewById(R.id.tvDate)
       }
}