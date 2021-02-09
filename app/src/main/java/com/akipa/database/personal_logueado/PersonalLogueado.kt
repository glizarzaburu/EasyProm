package com.akipa.database.personal_logueado

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "personal_logueado")
data class PersonalLogueado(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val apellido: String,
    val puesto: String
) {
    @Ignore
    val nombreCompleto = "$nombre $apellido"
}