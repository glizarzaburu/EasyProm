package com.akipa.database.personal_logueado

import androidx.room.*

@Dao
interface PersonalLogueadoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun iniciarSesion(personalLogueado: PersonalLogueado)

    @Query("SELECT * FROM personal_logueado LIMIT 1")
    fun obtenerPersonalLogueado(): PersonalLogueado?

    @Delete
    suspend fun cerrarSesion(personalLogueado: PersonalLogueado)
}