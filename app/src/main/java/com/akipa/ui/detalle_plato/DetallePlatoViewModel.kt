package com.akipa.ui.detalle_plato

import android.app.Application
import androidx.lifecycle.*
import com.akipa.database.CarritoDatabase
import com.akipa.database.PlatoEnCarrito
import com.akipa.entidades.Plato
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetallePlatoViewModel(application: Application) : AndroidViewModel(application) {

    private val viewmodelJob = Job()
    private val coroutineScope = CoroutineScope(viewmodelJob + Dispatchers.Main)

    private val database = CarritoDatabase.getInstance(application)

    /**
     * Variable a modificar internamente
     */
    private val _cantidadPlatos = MutableLiveData(1)

    /**
     * Variable a mostrar en la UI
     */
    val cantidadPlatos = Transformations.map(_cantidadPlatos) {
        it.toString()
    }

    fun incrementarCantidadPlato() {
        _cantidadPlatos.value = _cantidadPlatos.value?.plus(1)
    }

    fun reducirCantidadPlato() =
        _cantidadPlatos.value.let { cantidad ->
            if (cantidad != null) {
                if (cantidad > 1)
                    _cantidadPlatos.value = _cantidadPlatos.value?.minus(1)
            }
        }

    fun agregarPlatoAlCarrito(plato: Plato) {
        coroutineScope.launch {
            val platoEnCarrito =
                PlatoEnCarrito(plato.id, plato.nombre, plato.precio, _cantidadPlatos.value ?: 1)
            database.carritoDao.agregarPlatoAlCarrito(platoEnCarrito)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewmodelJob.cancel()
    }

    class DetallePlatoViewModelFactory(
        private val application: Application
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetallePlatoViewModel::class.java))
                return DetallePlatoViewModel(application) as T
            throw IllegalArgumentException("ViewModel Desconocido")
        }
    }
}