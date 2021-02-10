package com.akipa.dto.request

/**
 * Clase pare registrar un plato
 */
data class PlatoRequest(
    val nombre: String,
    val precio: Double,
    val foto: String,
    val descripcion: String?
)