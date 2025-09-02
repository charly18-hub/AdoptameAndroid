package com.example.adoptame.Eventos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAsociacion
import com.example.adoptame.Adapter.RecyclerAdapterEventos
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Modal.ModalAsociacion
import com.example.adoptame.Modal.ModalEventos
import com.example.adoptame.R

class EventosActivity : AppCompatActivity() {

    // on below line we are creating variables
    // for our swipe to refresh layout,
    // recycler view, adapter and list.
    lateinit var EventosRV: RecyclerView
    lateinit var eventosRVAdapter: RecyclerAdapterEventos
    lateinit var eventosList: ArrayList<ModalEventos>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_eventos)
        // on below line we are initializing
        // our views with their ids.
        EventosRV = findViewById(R.id.idRVEventos)

        // on below line we are initializing our list
        eventosList = ArrayList()

        // on below line we are creating a variable
        // for our grid layout manager and specifying
        // column count as 2
        val layoutManager = GridLayoutManager(this, 1)

        EventosRV.layoutManager = layoutManager

        // on below line we are initializing our adapter
        eventosRVAdapter = RecyclerAdapterEventos(eventosList, this)

        // on below line we are setting
        // adapter to our recycler view.
        EventosRV.adapter = eventosRVAdapter

        // on below line we are adding data to our list
        eventosList.add(ModalEventos("Adopta Huellitas", R.drawable.adopta_huellitas))
        eventosList.add(ModalEventos("Adopta un Angel", R.drawable.adopta_anegl))
        eventosList.add(ModalEventos("Patitas de Amor", R.drawable.patitas_amor))
        eventosList.add(ModalEventos("Zadrigman", R.drawable.zadrigman))
        eventosList.add(ModalEventos("Adopta un Angel", R.drawable.adopta_anegl))

        // on below line we are notifying adapter
        // that data has been updated.
        eventosRVAdapter.notifyDataSetChanged()

        val btnBack: View = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intentHome = Intent(this, DesktopActivity::class.java)
            startActivity(intentHome)
            finish()
        }
    }


}