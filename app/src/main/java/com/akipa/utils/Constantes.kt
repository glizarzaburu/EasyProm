package com.akipa.utils

import com.akipa.database.personal_logueado.PersonalLogueado

object Constantes {
    const val CANTIDAD_PLATOS_MINIMA = 1
    const val CANTIDAD_PLATOS_MAXIMA = 10

    /**
     * Mantendrá info del personal logueado actualmente.
     * Si es que su valor es nulo significa que no hay sesión
     * iniciada.
     */
    var personalAkipaLogueado: PersonalLogueado? = null
}