package com.akipa.database.personal_logueado

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonalLogueadoDao {

    @Insert
    suspend fun iniciarSesion(personalLogueado: PersonalLogueado)

    @Query("SELECT * FROM personal_logueado LIMIT 1")
    fun obtenerPersonalLogueado(): PersonalLogueado?

    @Delete
    suspend fun cerrarSesion(personalLogueado: PersonalLogueado)
}