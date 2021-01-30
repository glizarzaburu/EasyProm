package com.akipa.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.akipa.utils.formatearPrecio

@Entity(tableName = "platos_en_carrito")
data class PlatoEnCarrito(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val precio: Double,
    var cantidad: Int
) {
    val precioFormateado = precio.formatearPrecio()
}