package com.akipa.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlatoEnCarritoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregarPlatoAlCarrito(plato: PlatoEnCarrito)

    @Update
    fun cambiarCantidadDePlatos(plato: PlatoEnCarrito)

    @Delete
    fun quitarPlatoDelCarrito(plato: PlatoEnCarrito)

    @Query("DELETE FROM platos_en_carrito")
    fun quitarTodosLosPlatos()

    @Query("SELECT * FROM platos_en_carrito")
    fun obtenerTodosPlatosDelCarrito(): LiveData<List<PlatoEnCarrito>>
}