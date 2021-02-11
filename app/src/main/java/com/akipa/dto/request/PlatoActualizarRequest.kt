package com.akipa.dto.request

data class PlatoActualizarRequest(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val foto: String,
    val descripcion: String?
)