package com.example.adoptame.Eventos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAsociacion
import com.example.adoptame.Adapter.RecyclerAdapterEventos
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Modal.ModalAsociacion
import com.example.adoptame.Modal.ModalEventos
import com.example.adoptame.R
import com.example.adoptame.utils.ShimmerClass

class EventosActivity : AppCompatActivity() {

    lateinit var EventosRV: RecyclerView
    lateinit var eventosRVAdapter: RecyclerAdapterEventos
    lateinit var eventosList: ArrayList<ModalEventos>
    lateinit var ShimmerUtils: ShimmerClass

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initShimmerUtils()
        enableEdgeToEdge()

        setContentView(R.layout.activity_eventos)
        EventosRV = findViewById(R.id.idRVEventos)
        eventosList = ArrayList()
        EventosRV.layoutManager = LinearLayoutManager(this)
        eventosRVAdapter = RecyclerAdapterEventos(eventosList, this)
        EventosRV.adapter = eventosRVAdapter

        Handler().postDelayed({


            eventosList.add(
                ModalEventos(
                    nameEvento = "Adopta Huellitas",
                    location = "Parque Fundidora",
                    date = "Sáb 19 Feb · 11:00 am",
                    pets = "12",
                    courseImg = R.drawable.adopta_huellitas,
                )
            )

            eventosList.add(
                ModalEventos(
                    nameEvento = "Adopta Huellitas",
                    location = "Parque Mexico",
                    date = "Sáb 6 Feb · 11:00 am",
                    pets = "12",
                    courseImg = R.drawable.adopta_huellitas,
                )
            )
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
    private fun initShimmerUtils(){
        ShimmerUtils = ShimmerClass()
    }



}