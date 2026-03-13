package com.example.adoptame.presentation.asociaciones.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adoptame.domain.entity.Association
import com.example.adoptame.domain.usecase.GetAssociationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * Model: estado de la pantalla de asociaciones (MVVM).
 */
data class AsociacionesUiState(
    val associations: List<Association> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)

/**
 * ViewModel para Asociaciones (MVVM). Usa solo casos de uso (capa domain).
 */
class AsociacionesViewModel(
    private val getAssociationsUseCase: GetAssociationsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AsociacionesUiState())
    val uiState: StateFlow<AsociacionesUiState> = _uiState.asStateFlow()

    init {
        loadAssociations()
    }

    fun loadAssociations() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            getAssociationsUseCase(verified = true)
                .catch { e ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = e.message,
                        associations = emptyList()
                    )
                }
                .collect { result ->
                    result.fold(
                        onSuccess = { list ->
                            _uiState.value = AsociacionesUiState(
                                associations = list,
                                isLoading = false,
                                error = null
                            )
                        },
                        onFailure = { e ->
                            _uiState.value = _uiState.value.copy(
                                isLoading = false,
                                error = e.message,
                                associations = emptyList()
                            )
                        }
                    )
                }
        }
    }
}
