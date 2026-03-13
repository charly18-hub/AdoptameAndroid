package com.example.adoptame.domain.entity

/**
 * Entidad de dominio: Asociación.
 * Sin dependencias de framework ni fuentes de datos.
 */
data class Association(
    val name: String = "",
    val city: String = "",
    val dogs: Int = 0,
    val cats: Int = 0,
    val verified: Boolean = true
)
