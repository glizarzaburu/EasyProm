package com.akipa.dto

import com.akipa.entidades.Plato
import com.squareup.moshi.Json

data class ListadoPlatos(
    @Json(name = "PLATOS")
    val platos: List<Plato>
)