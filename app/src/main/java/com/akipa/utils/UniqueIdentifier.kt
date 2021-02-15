package com.akipa.utils

import android.os.Build
import java.util.*

object UniqueIdentifier {

    fun getUniqueIdentifier(): String {
        val devId =
            "35${Build.BOARD.length % 10}${Build.BRAND.length % 10}${Build.DEVICE.length % 10}" +
                    "${Build.MANUFACTURER.length % 10}${Build.MODEL.length % 10}${Build.PRODUCT.length % 10}"
        val serial = try {
            android.os.Build::class.java.getField("SERIAL")[null]?.toString()
        } catch (e: Exception) {
            "Serial"
        }

        return UUID(devId.hashCode().toLong(), serial.hashCode().toLong()).toString()
    }
}