package com.example.adoptame.domain.repository

import com.example.adoptame.domain.entity.Events
import com.example.adoptame.domain.entity.Pet
import kotlinx.coroutines.flow.Flow


/**
 * Contrato del repositorio de mascotas (capa domain).
 * La implementación vive en la capa data.
 */
interface EventsRepository {
    /**
     * Obtiene las mascotas disponibles por tipo.
     * @return Flow con la lista
     */
    fun getEvents(verified: Boolean): Flow<Result<List<Events>>>
}