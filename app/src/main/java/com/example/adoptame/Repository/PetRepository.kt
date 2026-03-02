package com.example.adoptame.Repository

import com.example.adoptame.Modal.Pet
import com.google.firebase.firestore.FirebaseFirestore

class PetRepository {
    private val db = FirebaseFirestore.getInstance()

    fun getPets(type: String, onResult: (List<Pet>) -> Unit) {

        db.collection("pets")
            .whereEqualTo("type", type)
            .whereEqualTo("status", "available")
            .get()
            .addOnSuccessListener { result ->

               // println("DOCUMENTS SIZE: ${result.size()}")

                val pets = result.map { document ->
                    println("DATA: ${document.data}")
                    document.toObject(Pet::class.java)
                }

                onResult(pets)
            }
            .addOnFailureListener {
                //println("ERROR FIRESTORE: ${it.message}")
                onResult(emptyList())
            }

    }
}