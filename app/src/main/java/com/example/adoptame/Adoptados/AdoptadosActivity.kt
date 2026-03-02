package com.example.adoptame.Adoptados

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAdoptados
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.R
import com.example.adoptame.utils.DialogsUtilsClass
import com.example.adoptame.utils.GetDataClass
import com.example.adoptame.utils.ShimmerClass
import com.example.adoptame.utils.getSpecieUtils

class AdoptadosActivity : AppCompatActivity() {

    lateinit var adoptadosRV: RecyclerView
    lateinit var adoptadosRVAdapter: RecyclerAdapterAdoptados
    lateinit var adoptadosList: ArrayList<ModalAdoptados>
    lateinit var shimmerUtils : ShimmerClass
    lateinit var dialogComercial : DialogsUtilsClass
    lateinit var recyclerData : GetDataClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adoptados)
        getSpecie()
        timeDialog()
        navHome()
        initShimmerUtils()
        initDialogComercial()
        initRecyclerData()
    }

    private fun initShimmerUtils(){ shimmerUtils = ShimmerClass() }

    private fun initDialogComercial(){ dialogComercial = DialogsUtilsClass() }

    private fun initRecyclerData(){ recyclerData = GetDataClass() }

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
            val data = recyclerData.getDogList()
            adoptadosList.addAll(data)
            shimmerUtils.stopLoading(adoptadosRVAdapter)

        },1500)
    }

    private fun initReciclerViewCats(){
        adoptadosRV = findViewById(R.id.idRVCourses)
        adoptadosList = ArrayList()
        val layoutManager = GridLayoutManager(this, 2)
        adoptadosRV.layoutManager = layoutManager
        adoptadosRVAdapter = RecyclerAdapterAdoptados(adoptadosList, this)
        adoptadosRV.adapter = adoptadosRVAdapter
        Handler().postDelayed({
            val data = recyclerData.getCatList()
            adoptadosList.addAll(data)
            shimmerUtils.stopLoading(adoptadosRVAdapter)

        },1500)
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