package com.example.adoptame.data.repository

import com.example.adoptame.domain.entity.Association
import com.example.adoptame.domain.repository.AssociationRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/**
 * Implementación del repositorio de asociaciones usando Firestore.
 * Pertenece a la capa data; depende solo de domain (interfaz y entidad).
 */
class AssociationRepositoryImpl(
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) : AssociationRepository {

    override fun getAssociations(verified: Boolean): Flow<Result<List<Association>>> = callbackFlow {
        firestore.collection("association")
            .whereEqualTo("verified", verified)
            .get()
            .addOnSuccessListener { result ->
                val list = result.map { doc ->
                    doc.toObject(Association::class.java)
                }
                trySend(Result.success(list))
                close()
            }
            .addOnFailureListener { e ->
                trySend(Result.failure(e))
                close()
            }
        awaitClose { }
    }
}
