package com.example.adoptame.presentation.Eventos.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.R
import com.example.adoptame.adapter.RecyclerAdapterEventos
import com.example.adoptame.data.repository.EventsRepositoryImpl
import com.example.adoptame.domain.usecase.GetEventsUseCase
import com.example.adoptame.presentation.Desktop.DesktopActivity
import com.example.adoptame.presentation.Eventos.viewModel.EventsViewModel
import com.example.adoptame.presentation.Eventos.viewModel.EventsViewModelFactory
import com.example.adoptame.utils.ShimmerClass
import kotlinx.coroutines.launch
import kotlin.getValue

/**
 * View (MVVM): pantalla de Eventos. Solo observa el ViewModel y actualiza la UI.
 */

class EventosActivity : AppCompatActivity() {

    private lateinit var EventosRV: RecyclerView
    private lateinit var eventosRVAdapter: RecyclerAdapterEventos
    private val ShimmerUtils = ShimmerClass()

    private val viewModel: EventsViewModel by viewModels {
        val repository = EventsRepositoryImpl()
        val getEventsUseCase = GetEventsUseCase(repository)
        EventsViewModelFactory(getEventsUseCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eventos)
        navHome()
        setupRecyclerView()
        observeState()
    }

    private fun setupRecyclerView() {
        EventosRV = findViewById(R.id.idRVEventos)
        EventosRV.layoutManager = LinearLayoutManager(this)
        EventosRV.setHasFixedSize(true)
        eventosRVAdapter = RecyclerAdapterEventos(ArrayList(), this)
        EventosRV.adapter = eventosRVAdapter
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateEvents.collect { state ->
                    eventosRVAdapter.updateList(state.events)
                    if (!state.isLoading) {
                        ShimmerUtils.stopLoadingEventos(eventosRVAdapter)
                    }

                }
            }
        }
    }

    private fun navHome() {

        val btnBack: View = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intentHome = Intent(this, DesktopActivity::class.java)
            startActivity(intentHome)
            finish()

        }
    }
}
