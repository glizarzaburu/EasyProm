package com.akipa.utils

import com.akipa.database.personal_logueado.PersonalLogueado

object Constantes {
    const val CANTIDAD_PLATOS_MINIMA = 1
    const val CANTIDAD_PLATOS_MAXIMA = 10
    const val PLATO_REGISTRADO_MENSAJE_EXITOSO = "Plato Registrado"
    const val PLATO_ACTUALIZADO_MENSAJE_EXITOSO = "Plato Actualizado"
    const val IMAGEN_NO_ACTUALIZADA = "Imagen no fue actualizada"

    /**
     * Mantendrá info del personal logueado actualmente.
     * Si es que su valor es nulo significa que no hay sesión
     * iniciada.
     */
    var personalAkipaLogueado: PersonalLogueado? = null
}