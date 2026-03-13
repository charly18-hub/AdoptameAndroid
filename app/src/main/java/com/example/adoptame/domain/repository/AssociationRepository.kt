package com.example.adoptame.domain.repository

import com.example.adoptame.domain.entity.Association
import kotlinx.coroutines.flow.Flow

/**
 * Contrato del repositorio de asociaciones (capa domain).
 * La implementación vive en la capa data.
 */
interface AssociationRepository {

    /**
     * Obtiene las asociaciones verificadas.
     * @param verified solo asociaciones verificadas si true
     * @return Flow con la lista (permite reaccionar a cambios en la UI)
     */
    fun getAssociations(verified: Boolean): Flow<Result<List<Association>>>
}
