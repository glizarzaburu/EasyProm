package com.akipa.dto

import com.akipa.database.personal_logueado.PersonalLogueado

data class PersonalAutorizado(
    val id: Int?,
    val nombre: String?,
    val apellido: String?,
    val puesto: String?
) {
    fun toPersonalLogueado(): PersonalLogueado =
        PersonalLogueado(id!!, nombre!!, apellido!!, puesto!!)
}