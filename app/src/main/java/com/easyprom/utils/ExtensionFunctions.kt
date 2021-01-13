package com.easyprom.utils

private const val SIMBOLO_SOLES = "S/"

/**
 * Se encarga de formatear el precio obtenido
 * agregandole el simbolo de soles
 */
fun Double.formatearPrecio(): String {
    return "$SIMBOLO_SOLES$this"
}