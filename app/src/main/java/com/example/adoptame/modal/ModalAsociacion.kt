package com.example.adoptame.modal

data class ModalAsociacion(
    val name: String,
    val city: String,
    val dogs: Int,
    val cats: Int,
    val logo: Int,      // drawable
    val verified: Boolean
)
