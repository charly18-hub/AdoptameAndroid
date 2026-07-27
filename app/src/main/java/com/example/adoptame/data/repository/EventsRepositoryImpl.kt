package com.example.adoptame.data.repository

import com.example.adoptame.domain.entity.Association
import com.example.adoptame.domain.entity.Events
import com.example.adoptame.domain.repository.AssociationRepository
import com.example.adoptame.domain.repository.EventsRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class EventsRepositoryImpl (
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) : EventsRepository  {

    /**
     * Implementación del repositorio de asociaciones usando Firestore.
     * Pertenece a la capa data; depende solo de domain (interfaz y entidad).
     */

        override fun getEvents(verified: Boolean): Flow<Result<List<Events>>> = callbackFlow {
            firestore.collection("events")
                .whereEqualTo("verified", verified)
                .get()
                .addOnSuccessListener { result ->
                    val list = result.map { doc ->
                        doc.toObject(Events::class.java)
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