package com.example.adoptame.presentation.Eventos.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.adoptame.data.repository.EventsRepositoryImpl
import com.example.adoptame.domain.usecase.GetEventsUseCase
import com.example.adoptame.presentation.Eventos.viewModel.EventsViewModel
import com.example.adoptame.presentation.Eventos.viewModel.EventsViewModelFactory
import com.example.adoptame.ui.theme.AdoptameTheme
import androidx.compose.runtime.getValue
import kotlin.getValue

/**
 * View (MVVM): pantalla de Eventos. Solo observa el ViewModel y actualiza la UI.
 */

class EventosActivity : ComponentActivity() {

    private val viewModel: EventsViewModel by viewModels {
        val repository = EventsRepositoryImpl()
        val useCase = GetEventsUseCase(repository)
        EventsViewModelFactory(useCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AdoptameTheme {

                val state by viewModel.uiStateEvents.collectAsStateWithLifecycle()

                EventosScreen(
                    state = state,
                    onBack = {
                        finish()
                    }
                )

            }

        }
    }
}