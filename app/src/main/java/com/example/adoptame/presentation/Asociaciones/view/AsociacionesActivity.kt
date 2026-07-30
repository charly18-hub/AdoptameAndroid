package com.example.adoptame.presentation.Asociaciones.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.adoptame.data.repository.AssociationRepositoryImpl
import com.example.adoptame.domain.usecase.GetAssociationsUseCase
import com.example.adoptame.presentation.Asociaciones.viewmodel.AsociacionesViewModel
import com.example.adoptame.presentation.Asociaciones.viewmodel.AsociacionesViewModelFactory
import com.example.adoptame.ui.theme.AdoptameTheme

class AsociacionesActivity : ComponentActivity() {

    private val viewModel: AsociacionesViewModel by viewModels {
        val repository = AssociationRepositoryImpl()
        val useCase = GetAssociationsUseCase(repository)
        AsociacionesViewModelFactory(useCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AdoptameTheme {

                val state by viewModel.uiState.collectAsStateWithLifecycle()

                AsociacionesScreen(
                    state = state,
                    onSearch = {
                        // lo implementaremos después
                    }
                )

            }
        }
    }
}