package com.example.adoptame.Adoptados

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAdoptados
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.R
import android.widget.VideoView
import com.example.adoptame.utils.DialogsUtilsClass
import com.example.adoptame.utils.ShimmerClass
import com.example.adoptame.utils.getSpecieUtils

class AdoptadosActivity : AppCompatActivity() {

    lateinit var adoptadosRV: RecyclerView
    lateinit var adoptadosRVAdapter: RecyclerAdapterAdoptados
    lateinit var adoptadosList: ArrayList<ModalAdoptados>
    lateinit var shimmerUtils : ShimmerClass
    lateinit var dialogComercial : DialogsUtilsClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adoptados)
        getSpecie()
        timeDialog()
        navHome()
        initShimmerUtils()
        initDialogComercial()
    }

    private fun initShimmerUtils(){
        shimmerUtils = ShimmerClass()
    }

    private fun initDialogComercial(){
        dialogComercial = DialogsUtilsClass()
    }

    private fun getSpecie() {
        val especie = getSpecieUtils().getSpecie(this)
        when (especie) {
            "1" -> initReciclerView()
            "2" -> initReciclerViewCats()
        }
    }

    private fun initReciclerView(){
        adoptadosRV = findViewById(R.id.idRVCourses)
        adoptadosList = ArrayList()
        val layoutManager = GridLayoutManager(this, 2)
        adoptadosRV.layoutManager = layoutManager
        adoptadosRVAdapter = RecyclerAdapterAdoptados(adoptadosList, this)
        adoptadosRV.adapter = adoptadosRVAdapter

        Handler().postDelayed({

        adoptadosList.add(ModalAdoptados("Guera", R.drawable.pet,"2 meses", "Mix Chihuahua","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Spike", R.drawable.pet, "4 Años", "Beagle","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Chocolata", R.drawable.pet,"6 Meses","Mix Pastor","Enviar Solicitud"))
        adoptadosList.add(ModalAdoptados("Chaparra", R.drawable.pet,"8 meses", "Mix Beagle","Enviar Solicitud"))
        shimmerUtils.stopLoading(adoptadosRVAdapter)
        adoptadosRVAdapter.notifyDataSetChanged()

        },1500)
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
        val tiempoTranscurrir = 1000
        val handler: Handler = Handler()
        handler.postDelayed(Runnable {
           dialogComercial.showDefaultComercial(this)
        }, tiempoTranscurrir.toLong())
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