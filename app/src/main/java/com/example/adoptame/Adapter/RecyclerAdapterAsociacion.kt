package com.example.adoptame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.Modal.ModalAsociacion
import com.example.adoptame.R

class RecyclerAdapterAsociacion(
    // on below line we are passing variables
    // as course list and context
    private val courseList: ArrayList<ModalAsociacion>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerAdapterAsociacion.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterAsociacion.CourseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_asociacion,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterAsociacion.CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.courseNameTV.text = courseList.get(position).name
        holder.courseIV.setImageResource(courseList.get(position).logo)
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val courseNameTV: TextView = itemView.findViewById(R.id.txtName)
        val courseIV: ImageView = itemView.findViewById(R.id.imgLogo)
    }
}