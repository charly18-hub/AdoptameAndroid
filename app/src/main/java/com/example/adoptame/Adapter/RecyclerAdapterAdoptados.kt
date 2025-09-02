package com.example.adoptame.Adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.Modal.ModalAsociacion
import com.example.adoptame.R

class RecyclerAdapterAdoptados (
    // on below line we are passing variables
    // as course list and context
    private val adoptadosList: ArrayList<ModalAdoptados>,
    private val context: Context
    ) : RecyclerView.Adapter<RecyclerAdapterAdoptados.AdoptadosViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): RecyclerAdapterAdoptados.AdoptadosViewHolder {
            // this method is use to inflate the layout file
            // which we have created for our recycler view.
            // on below line we are inflating our layout file.
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_adoptado,
                parent, false
            )
            // at last we are returning our view holder
            // class with our item View File.
            return AdoptadosViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: RecyclerAdapterAdoptados.AdoptadosViewHolder, position: Int) {
            // on below line we are setting data to our text view and our image view.
            holder.nameAdoptado.text = adoptadosList.get(position).adoptadoName
            holder.imgAdoptado.setImageResource(adoptadosList.get(position).adoptadoImg)
            holder.edadAdoptado.text = adoptadosList.get(position).adoptadoEdad
            holder.razaAdoptado.text = adoptadosList.get(position).adoptadoRaza
            holder.btn_enviar_solicitud.text = adoptadosList.get(position).adoptadoBtnSend

            holder.btn_enviar_solicitud.setOnClickListener {
                val alertDialog = androidx.appcompat.app.AlertDialog.Builder(context)
                val inflater = LayoutInflater.from(context)
                alertDialog.apply {
                    setView(inflater.inflate(R.layout.solicitud_enviada_dog, null))
                    setPositiveButton("Aceptar") { _: DialogInterface?, _: Int ->
                    }
                    setOnDismissListener {
                    }
                }.create().show()
            }
        }

        override fun getItemCount(): Int {
            // on below line we are
            // returning our size of our list
            return adoptadosList.size
        }

        class AdoptadosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // on below line we are initializing our course name text view and our image view.
            val nameAdoptado: TextView = itemView.findViewById(R.id.idName)
            val imgAdoptado: ImageView = itemView.findViewById(R.id.idImg)
            val edadAdoptado: TextView = itemView.findViewById(R.id.idEdad)
            val razaAdoptado: TextView = itemView.findViewById(R.id.idRaza)
            val btn_enviar_solicitud: TextView = itemView.findViewById(R.id.btnEnviarSolicitud)
        }
}