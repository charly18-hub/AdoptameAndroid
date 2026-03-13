package com.example.adoptame.presentation.adoptados.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adoptame.domain.entity.Pet
import com.example.adoptame.domain.usecase.GetPetsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * Model: estado de la pantalla de adoptados (MVVM).
 */
data class AdoptadosUiState(
    val pets: List<Pet> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)

/**
 * ViewModel para Adoptados (MVVM). Usa solo casos de uso (capa domain).
 */
class AdoptadosViewModel(
    private val getPetsUseCase: GetPetsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AdoptadosUiState())
    val uiState: StateFlow<AdoptadosUiState> = _uiState.asStateFlow()

    fun loadPets(type: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            getPetsUseCase(type)
                .catch { e ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = e.message,
                        pets = emptyList()
                    )
                }
                .collect { result ->
                    result.fold(
                        onSuccess = { list ->
                            _uiState.value = AdoptadosUiState(
                                pets = list,
                                isLoading = false,
                                error = null
                            )
                        },
                        onFailure = { e ->
                            _uiState.value = _uiState.value.copy(
                                isLoading = false,
                                error = e.message,
                                pets = emptyList()
                            )
                        }
                    )
                }
        }
    }
}
