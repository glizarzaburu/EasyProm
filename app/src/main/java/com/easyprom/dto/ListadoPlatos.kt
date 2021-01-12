package com.easyprom.dto

import com.easyprom.entidades.Plato
import com.squareup.moshi.Json

data class ListadoPlatos(
    @Json(name = "PLATOS")
    val platos: List<Plato>
)