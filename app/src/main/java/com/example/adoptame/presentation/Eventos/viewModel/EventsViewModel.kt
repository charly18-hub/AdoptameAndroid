package com.example.adoptame.presentation.Eventos.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adoptame.domain.entity.Association
import com.example.adoptame.domain.entity.Events
import com.example.adoptame.domain.usecase.GetAssociationsUseCase
import com.example.adoptame.domain.usecase.GetEventsUseCase
import com.example.adoptame.presentation.Asociaciones.viewmodel.AsociacionesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


/**
 * Model: estado de la pantalla de asociaciones (MVVM).
 */
data class EventsUiState(
    val events: List<Events> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)

/**
 * ViewModel para Asociaciones (MVVM). Usa solo casos de uso (capa domain).
 */

class EventsViewModel (
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(EventsUiState())
    val uiStateEvents: StateFlow<EventsUiState> = _uiState.asStateFlow()

    init {
        loadEvents()
    }

    fun loadEvents() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            getEventsUseCase(verified = true)
                .catch { e ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = e.message,
                        events = emptyList()
                    )
                }
                .collect { result ->
                    result.fold(
                        onSuccess = { list ->
                            _uiState.value = EventsUiState(
                                events = list,
                                isLoading = false,
                                error = null
                            )
                        },
                        onFailure = { e ->
                            _uiState.value = _uiState.value.copy(
                                isLoading = false,
                                error = e.message,
                                events = emptyList()
                            )
                        }
                    )
                }
        }
    }
}
