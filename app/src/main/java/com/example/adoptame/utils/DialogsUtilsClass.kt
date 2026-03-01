package com.example.adoptame.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.widget.ImageView
import android.widget.VideoView
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

}