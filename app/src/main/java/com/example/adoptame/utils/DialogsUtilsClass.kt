package com.example.adoptame.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.adoptame.R

class DialogsUtilsClass {

     fun showDefaultComercial(context: Context) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.publicidad_view)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val videoView = dialog.findViewById<VideoView>(R.id.videoView)
        val btnClose = dialog.findViewById<ImageView>(R.id.btnClose)
        val videoPath = "android.resource://${context.packageName}/${R.raw.croquetas}"
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()

        btnClose.setOnClickListener {
            videoView.stopPlayback()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showDialogGracias(context: Context){
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.solicitud_enviada_dog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.findViewById<TextView>(R.id.btnClose)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.btnTrack)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showDialogDog(context: Context){
        val alertDialog = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        alertDialog.apply {
            setView(inflater.inflate(R.layout.dialog_alert1, null))
            setPositiveButton("Aceptar") { _: DialogInterface?, _: Int ->
            }
            setNegativeButton("Salir") { _, _ ->
                if (context is AppCompatActivity) {
                    context.finish()
                }            }
            setOnDismissListener {
            }
        }.create().show()
    }

    fun showDialogCat(context : Context){
        val alertDialog = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        alertDialog.apply {
            setView(inflater.inflate(R.layout.dialog_alert1_cat, null))
            setPositiveButton("Aceptar") { _: DialogInterface?, _: Int ->
            }
            setNegativeButton("Salir") { _, _ ->
                if (context is AppCompatActivity) {
                    context.finish()
                }            }
            setOnDismissListener {
            }
        }.create().show()
    }
}