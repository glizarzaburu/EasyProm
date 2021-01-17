package com.easyprom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PlatoEnCarrito::class], version = 1, exportSchema = false)
abstract class CarritoDatabase : RoomDatabase() {

    abstract val carritoDao: PlatoEnCarritoDao

    companion object {

        @Volatile
        private var INSTANCE: CarritoDatabase? = null

        fun getInstance(context: Context): CarritoDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CarritoDatabase::class.java,
                        "pokemon_db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}