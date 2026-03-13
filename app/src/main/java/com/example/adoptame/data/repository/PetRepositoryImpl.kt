package com.example.adoptame.data.repository

import com.example.adoptame.domain.entity.Pet
import com.example.adoptame.domain.repository.PetRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/**
 * Implementación del repositorio de mascotas usando Firestore.
 * Pertenece a la capa data; depende solo de domain (interfaz y entidad).
 */
class PetRepositoryImpl(
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) : PetRepository {

    override fun getPets(type: String): Flow<Result<List<Pet>>> = callbackFlow {
        firestore.collection("pets")
            .whereEqualTo("type", type)
            .whereEqualTo("status", "available")
            .get()
            .addOnSuccessListener { result ->
                val list = result.map { doc ->
                    doc.toObject(Pet::class.java)
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
