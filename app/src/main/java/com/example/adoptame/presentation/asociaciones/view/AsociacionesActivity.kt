package com.example.adoptame.presentation.asociaciones.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.adapter.RecyclerAdapterAsociacion
import com.example.adoptame.presentation.Desktop.DesktopActivity
import com.example.adoptame.R
import com.example.adoptame.data.repository.AssociationRepositoryImpl
import com.example.adoptame.domain.usecase.GetAssociationsUseCase
import com.example.adoptame.presentation.asociaciones.viewmodel.AsociacionesViewModel
import com.example.adoptame.presentation.asociaciones.viewmodel.AsociacionesViewModelFactory
import com.example.adoptame.utils.ShimmerClass
import kotlinx.coroutines.launch

/**
 * View (MVVM): pantalla de asociaciones. Solo observa el ViewModel y actualiza la UI.
 */
class AsociacionesActivity : AppCompatActivity() {

    private lateinit var asociacionRV: RecyclerView
    private lateinit var asociacionRVAdapter: RecyclerAdapterAsociacion
    private val shimmerUtils = ShimmerClass()

    private val viewModel: AsociacionesViewModel by viewModels {
        val repository = AssociationRepositoryImpl()
        val getAssociationsUseCase = GetAssociationsUseCase(repository)
        AsociacionesViewModelFactory(getAssociationsUseCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_asociaciones)
        setupRecyclerView()
        observeState()
    }

    private fun setupRecyclerView() {
        asociacionRV = findViewById(R.id.idRVCourses)
        asociacionRV.layoutManager = LinearLayoutManager(this)
        asociacionRV.setHasFixedSize(true)
        asociacionRVAdapter = RecyclerAdapterAsociacion(ArrayList(), this)
        asociacionRV.adapter = asociacionRVAdapter
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    asociacionRVAdapter.updateList(state.associations)
                    if (!state.isLoading) {
                        shimmerUtils.stopLoadingAsociaciones(asociacionRVAdapter)
                    }
                }
            }
        }
    }

    private fun goHome() {
        val intent = Intent(this, DesktopActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
