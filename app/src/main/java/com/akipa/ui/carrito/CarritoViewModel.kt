package com.akipa.ui.carrito

import android.app.Application
import androidx.lifecycle.*
import com.akipa.database.CarritoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class CarritoViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = CarritoDatabase.getInstance(application.applicationContext)

    /**
     * Lista de todos los platos agregados al carrito
     */
    val platosEnCarrito = database.carritoDao.obtenerTodosPlatosDelCarrito()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    /**
     * Cuando un ViewModel tiene parametros se necesita crear un
     * Factory para que se le pueda interpretar. Este se encarga de
     * darnos un CarritoViewModel
     */
    class CarritoViewModelFactory(
        private val application: Application
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CarritoViewModel::class.java))
                return CarritoViewModel(application) as T
            throw IllegalArgumentException("ViewModel Desconocido")
        }
    }
}