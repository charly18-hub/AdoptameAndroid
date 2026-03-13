package com.example.adoptame.presentation.Eventos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.adapter.RecyclerAdapterEventos
import com.example.adoptame.presentation.Desktop.DesktopActivity
import com.example.adoptame.modal.ModalEventos
import com.example.adoptame.R
import com.example.adoptame.utils.GetDataClass
import com.example.adoptame.utils.ShimmerClass

class EventosActivity : AppCompatActivity() {

    lateinit var EventosRV: RecyclerView
    lateinit var eventosRVAdapter: RecyclerAdapterEventos
    lateinit var eventosList: ArrayList<ModalEventos>
    lateinit var ShimmerUtils: ShimmerClass
    lateinit var recyclerData : GetDataClass


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eventos)
        initShimmerUtils()
        initRecyclerData()
        getDataReciclerViewEvents()
    }
    private fun initShimmerUtils(){ ShimmerUtils = ShimmerClass() }

    private fun initRecyclerData(){ recyclerData = GetDataClass() }

    private fun getDataReciclerViewEvents(){
        EventosRV = findViewById(R.id.idRVEventos)
        eventosList = ArrayList()
        EventosRV.layoutManager = LinearLayoutManager(this)
        eventosRVAdapter = RecyclerAdapterEventos(eventosList, this)
        EventosRV.adapter = eventosRVAdapter

        Handler().postDelayed({
            val data = recyclerData.getEventosData()
            eventosList.addAll(data)
            ShimmerUtils.stopLoadingEventos(eventosRVAdapter)
            eventosRVAdapter.notifyDataSetChanged()

            val btnBack: View = findViewById(R.id.btnBack)
            btnBack.setOnClickListener {
                val intentHome = Intent(this, DesktopActivity::class.java)
                startActivity(intentHome)
                finish()
            }
        },1500)
    }
}
