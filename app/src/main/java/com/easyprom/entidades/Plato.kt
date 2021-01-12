package com.easyprom.entidades

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plato(
    val id: Int,
    var nombre: String,
    var precio: Double,
    var estado: Int = 1, // 0 -> no disponible | 1 -> disponible
    var urlImagen: String? = null,
    var descripcion: String? = null
) : Parcelable