package com.example.adoptame.presentation.Eventos.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.domain.usecase.GetEventsUseCase

class EventsViewModelFactory (
    private val getEventsUseCase: GetEventsUseCase
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass != EventsViewModel::class.java) {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
            return EventsViewModel(getEventsUseCase) as T
        }
    }
