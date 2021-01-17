package com.easyprom.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "platos_en_carrito")
data class PlatoEnCarrito(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)