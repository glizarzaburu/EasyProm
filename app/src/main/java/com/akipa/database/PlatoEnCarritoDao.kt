package com.akipa.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlatoEnCarritoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarPlatoAlCarrito(plato: PlatoEnCarrito)

    @Update
    suspend fun cambiarCantidadDePlatos(plato: PlatoEnCarrito)

    @Delete
    suspend fun quitarPlatoDelCarrito(plato: PlatoEnCarrito)

    @Query("DELETE FROM platos_en_carrito")
    suspend fun quitarTodosLosPlatos()

    @Query("SELECT * FROM platos_en_carrito")
    fun obtenerTodosPlatosDelCarrito(): LiveData<List<PlatoEnCarrito>>
}