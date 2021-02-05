package com.akipa.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akipa.database.personal_logueado.PersonalLogueado
import com.akipa.database.personal_logueado.PersonalLogueadoDao
import com.akipa.database.plato_en_carrito.PlatoEnCarrito
import com.akipa.database.plato_en_carrito.PlatoEnCarritoDao

@Database(
    entities = [PlatoEnCarrito::class, PersonalLogueado::class],
    version = 2,
    exportSchema = false
)
abstract class CarritoDatabase : RoomDatabase() {

    abstract val carritoDao: PlatoEnCarritoDao
    abstract val personalDao: PersonalLogueadoDao

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
                        "Akipa_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}