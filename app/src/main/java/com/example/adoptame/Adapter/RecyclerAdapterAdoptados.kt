package com.example.adoptame.Adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.R
import com.example.adoptame.utils.DialogsUtilsClass
import com.facebook.shimmer.ShimmerFrameLayout

class RecyclerAdapterAdoptados(
    private val adoptadosList: ArrayList<ModalAdoptados>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerAdapterAdoptados.AdoptadosViewHolder>() {

    lateinit var dialogAdopcionGracias : DialogsUtilsClass
    internal var isLoading = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdoptadosViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_adoptado, parent, false)
        initDialogGracias()
        return AdoptadosViewHolder(itemView)
    }

    private fun initDialogGracias(){
        dialogAdopcionGracias = DialogsUtilsClass()
    }

    override fun onBindViewHolder(holder: AdoptadosViewHolder, position: Int) {

        if (isLoading) {
            holder.shimmer.visibility = View.VISIBLE
            holder.card.visibility = View.GONE
            holder.shimmer.startShimmer()
        } else {
            holder.shimmer.stopShimmer()
            holder.shimmer.visibility = View.GONE
            holder.card.visibility = View.VISIBLE

            val item = adoptadosList[position]
            holder.edad.text = item.adoptadoEdad
            holder.raza.text = item.adoptadoRaza
            holder.name.text = item.adoptadoName
            holder.img.setImageResource(item.adoptadoImg)
            holder.btn.text = item.adoptadoBtnSend

            holder.btn.setOnClickListener {
                dialogAdopcionGracias.showDialogGracias(context)
            }
        }

    }


    override fun getItemCount(): Int {
        return if (isLoading) 6 else adoptadosList.size
    }

    class AdoptadosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val shimmer: ShimmerFrameLayout = itemView.findViewById(R.id.shimmerLayout)
        val card: View = itemView.findViewById(R.id.cardReal)
        val raza: TextView = card.findViewById(R.id.raza)
        val edad: TextView = card.findViewById(R.id.edad)
        val name: TextView = card.findViewById(R.id.idName)
        val img: ImageView = card.findViewById(R.id.idImg)
        val btn: TextView = card.findViewById(R.id.btnEnviarSolicitud)

    }
}
