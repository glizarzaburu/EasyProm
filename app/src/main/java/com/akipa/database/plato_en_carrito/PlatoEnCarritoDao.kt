package com.akipa.database.plato_en_carrito

import androidx.lifecycle.LiveData
import androidx.room.*
import com.akipa.database.plato_en_carrito.PlatoEnCarrito

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