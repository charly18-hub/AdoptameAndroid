package com.example.adoptame.presentation.adoptados.view

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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.adapter.RecyclerAdapterAdoptados
import com.example.adoptame.presentation.Desktop.DesktopActivity
import com.example.adoptame.R
import com.example.adoptame.data.repository.PetRepositoryImpl
import com.example.adoptame.domain.usecase.GetPetsUseCase
import com.example.adoptame.presentation.adoptados.viewmodel.AdoptadosViewModel
import com.example.adoptame.presentation.adoptados.viewmodel.AdoptadosViewModelFactory
import com.example.adoptame.utils.DialogsUtilsClass
import com.example.adoptame.utils.ShimmerClass
import com.example.adoptame.utils.GetSpecieUtils
import kotlinx.coroutines.launch

/**
 * View (MVVM): pantalla de adoptados. Solo observa el ViewModel y actualiza la UI.
 */
class AdoptadosActivity : AppCompatActivity() {

    private lateinit var adoptadosRV: RecyclerView
    private lateinit var adoptadosRVAdapter: RecyclerAdapterAdoptados
    private val shimmerUtils = ShimmerClass()
    private val dialogComercial = DialogsUtilsClass()

    private val viewModel: AdoptadosViewModel by viewModels {
        val repository = PetRepositoryImpl()
        val getPetsUseCase = GetPetsUseCase(repository)
        AdoptadosViewModelFactory(getPetsUseCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adoptados)
        loadPetsBySpecie()
        timeDialog()
        navHome()
        setupRecyclerView()
        observeState()
    }

    private fun setupRecyclerView() {
        adoptadosRV = findViewById(R.id.idRVCourses)
        adoptadosRV.layoutManager = GridLayoutManager(this, 2)
        adoptadosRVAdapter = RecyclerAdapterAdoptados(ArrayList(), this)
        adoptadosRV.adapter = adoptadosRVAdapter
    }

    private fun loadPetsBySpecie() {
        val especie = GetSpecieUtils().getSpecie(this)
        when (especie) {
            "1" -> viewModel.loadPets("dog")
            "2" -> viewModel.loadPets("cat")
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    adoptadosRVAdapter.updateList(state.pets)
                    if (!state.isLoading) {
                        shimmerUtils.stopLoading(adoptadosRVAdapter)
                    }
                }
            }
        }
    }

    private fun timeDialog() {
        Handler(mainLooper).postDelayed({
            dialogComercial.showDefaultComercial(this)
        }, 1000L)
    }

    private fun navHome() {
        findViewById<View>(R.id.btnBack).setOnClickListener {
            startActivity(Intent(this, DesktopActivity::class.java))
            finish()
        }
    }
}
