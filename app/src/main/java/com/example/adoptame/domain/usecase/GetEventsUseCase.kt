package com.example.adoptame.domain.usecase

import com.example.adoptame.domain.entity.Events
import com.example.adoptame.domain.entity.Pet
import com.example.adoptame.domain.repository.EventsRepository
import com.example.adoptame.domain.repository.PetRepository
import kotlinx.coroutines.flow.Flow

class GetEventsUseCase(
    private val repository: EventsRepository
) {
    /**
     * Caso de uso: obtener mascotas disponibles por tipo.
     * Orquesta el repositorio y expone el resultado a la capa de presentación.
     */


        operator fun invoke(verified: Boolean = true): Flow<Result<List<Events>>> =
            repository.getEvents(verified)
    }
