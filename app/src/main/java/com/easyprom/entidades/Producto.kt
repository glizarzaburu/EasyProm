package com.easyprom.entidades

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Producto(val campo1: String, val campo2: String) :Parcelable