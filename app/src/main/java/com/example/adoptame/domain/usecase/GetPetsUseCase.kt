package com.example.adoptame.domain.usecase

import com.example.adoptame.domain.entity.Pet
import com.example.adoptame.domain.repository.PetRepository
import kotlinx.coroutines.flow.Flow

/**
 * Caso de uso: obtener mascotas disponibles por tipo.
 * Orquesta el repositorio y expone el resultado a la capa de presentación.
 */
class GetPetsUseCase(
    private val repository: PetRepository
) {

    operator fun invoke(type: String): Flow<Result<List<Pet>>> =
        repository.getPets(type)
}
