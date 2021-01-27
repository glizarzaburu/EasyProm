package com.akipa.entidades

import android.os.Parcelable
import com.akipa.utils.formatearPrecio
import com.squareup.moshi.Json
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plato(
    @Json(name = "idPlato")
    val id: Int,
    @Json(name = "nombrePlato")
    var nombre: String,
    @Json(name = "precioPlato")
    var precio: Double,
    @Json(name = "estadoPlato")
    var estado: Int = 1, // 0 -> no disponible | 1 -> disponible
    @Json(name = "imagenPlato")
    var urlImagen: String? = null,
    @Json(name = "descripcionPlato")
    var descripcion: String? = null
) : Parcelable {
    @IgnoredOnParcel
    val precioFormateado = precio.formatearPrecio()
}