package com.example.adoptame.Adoptados

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.service.controls.actions.FloatAction
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAdoptados
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.R
import android.widget.VideoView
import android.widget.MediaController

class AdoptadosActivity : AppCompatActivity() {
    // on below line we are creating variables
    // for our swipe to refresh layout,
    // recycler view, adapter and list.
    lateinit var adoptadosRV: RecyclerView
    lateinit var adoptadosRVAdapter: RecyclerAdapterAdoptados
    lateinit var adoptadosList: ArrayList<ModalAdoptados>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adoptados)
        getSpecie()
        timeDialog()
        navHome()

    }
    private fun getSpecie(){
        val sharedPreferences = applicationContext?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val especieType = sharedPreferences?.getString("especieType", "")
        if(especieType.equals("1")){
            initReciclerView()
        }
        if(especieType.equals("2")){
            initReciclerViewCats()
        }
    }
    private fun initReciclerView(){
        adoptadosRV = findViewById(R.id.idRVCourses)
        adoptadosList = ArrayList()
        val layoutManager = GridLayoutManager(this, 2)
        adoptadosRV.layoutManager = layoutManager
        adoptadosRVAdapter = RecyclerAdapterAdoptados(adoptadosList, this)
        adoptadosRV.adapter = adoptadosRVAdapter
        adoptadosList.add(ModalAdoptados("Guera", R.drawable.bebe2,"2 meses", "Mix Chihuahua","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Spike", R.drawable.bebe2, "4 Años", "Beagle","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Chocolata", R.drawable.bebe2,"6 Meses","Mix Pastor","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Chaparra", R.drawable.bebe2,"8 meses", "Mix Beagle","Enviar Solicitud"))
        adoptadosRVAdapter.notifyDataSetChanged()
    }
    private fun initReciclerViewCats(){
        adoptadosRV = findViewById(R.id.idRVCourses)
        adoptadosList = ArrayList()
        val layoutManager = GridLayoutManager(this, 2)
        adoptadosRV.layoutManager = layoutManager
        adoptadosRVAdapter = RecyclerAdapterAdoptados(adoptadosList, this)
        adoptadosRV.adapter = adoptadosRVAdapter
        adoptadosList.add(ModalAdoptados("Guera", R.drawable.cat1,"2 meses", "Mix Chihuahua","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Spike", R.drawable.cat1, "4 Años", "Beagle","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Chocolata", R.drawable.cat1,"6 Meses","Mix Pastor","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Chaparra", R.drawable.cat1,"8 meses", "Mix Beagle","Enviar Solicitud"))
        adoptadosRVAdapter.notifyDataSetChanged()
    }
    private fun timeDialog(){
        val tiempoTranscurrir = 1000 //1 segundo, 1000 millisegundos.
        val handler: Handler = Handler()
        handler.postDelayed(Runnable { //***Aquí agregamos el proceso a ejecutar.
            showDefaultDialog()
        }, tiempoTranscurrir.toLong()) //define el tiempo.
    }
    private fun showDefaultDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.publicidad_view)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val videoView = dialog.findViewById<VideoView>(R.id.videoView)
        val btnClose = dialog.findViewById<ImageView>(R.id.btnClose)

        val videoPath = "android.resource://$packageName/${R.raw.croquetas}"
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()

        btnClose.setOnClickListener {
            videoView.stopPlayback()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun navHome(){
        val btnBack: View = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intentHome = Intent(this, DesktopActivity::class.java)
            startActivity(intentHome)
            finish()
        }
    }
}