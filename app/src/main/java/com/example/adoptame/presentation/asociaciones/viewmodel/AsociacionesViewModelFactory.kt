package com.example.adoptame.presentation.asociaciones.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.domain.usecase.GetAssociationsUseCase

/**
 * Factory para crear [AsociacionesViewModel] con sus dependencias (use case).
 */
class AsociacionesViewModelFactory(
    private val getAssociationsUseCase: GetAssociationsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass != AsociacionesViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return AsociacionesViewModel(getAssociationsUseCase) as T
    }
}
