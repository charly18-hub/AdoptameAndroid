package com.example.adoptame.domain.usecase

import com.example.adoptame.domain.entity.Association
import com.example.adoptame.domain.repository.AssociationRepository
import kotlinx.coroutines.flow.Flow

/**
 * Caso de uso: obtener asociaciones verificadas.
 * Orquesta el repositorio y expone el resultado a la capa de presentación.
 */
class GetAssociationsUseCase(
    private val repository: AssociationRepository
) {

    operator fun invoke(verified: Boolean = true): Flow<Result<List<Association>>> =
        repository.getAssociations(verified)
}
