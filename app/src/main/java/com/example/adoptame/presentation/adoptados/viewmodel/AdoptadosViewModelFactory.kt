package com.example.adoptame.presentation.adoptados.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.domain.usecase.GetPetsUseCase

/**
 * Factory para crear [AdoptadosViewModel] con sus dependencias (use case).
 */
class AdoptadosViewModelFactory(
    private val getPetsUseCase: GetPetsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass != AdoptadosViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return AdoptadosViewModel(getPetsUseCase) as T
    }
}
