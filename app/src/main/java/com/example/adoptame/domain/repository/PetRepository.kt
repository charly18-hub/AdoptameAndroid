package com.example.adoptame.domain.repository

import com.example.adoptame.domain.entity.Pet
import kotlinx.coroutines.flow.Flow

/**
 * Contrato del repositorio de mascotas (capa domain).
 * La implementación vive en la capa data.
 */
interface PetRepository {

    /**
     * Obtiene las mascotas disponibles por tipo.
     * @param type "dog" o "cat"
     * @return Flow con la lista
     */
    fun getPets(type: String): Flow<Result<List<Pet>>>
}
