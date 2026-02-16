package com.example.adoptame.Adapter

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
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
            holder.btn_enviar_solicitud.isClickable = true
            holder.btn_enviar_solicitud.isFocusable = true

            holder.btn_enviar_solicitud.setOnClickListener {


                val dialog = Dialog(context)
                dialog.setContentView(R.layout.solicitud_enviada_dog)
                dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                dialog.findViewById<TextView>(R.id.btnClose).setOnClickListener {
                    dialog.dismiss()
                }

                dialog.findViewById<Button>(R.id.btnTrack).setOnClickListener {
                    // abrir pantalla de seguimiento
                    dialog.dismiss()
                }

                dialog.show()
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