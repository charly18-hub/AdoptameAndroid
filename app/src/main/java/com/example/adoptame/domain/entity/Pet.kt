package com.example.adoptame.domain.entity

/**
 * Entidad de dominio: Mascota.
 * Sin dependencias de framework ni fuentes de datos.
 */
data class Pet(
    val name: String = "",
    val age: String = "",
    val breed: String = "",
    val type: String = "",
    val imageUrl: String = "",
    val status: String = ""
)
