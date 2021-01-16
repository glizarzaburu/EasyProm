package com.easyprom.detalle_plato

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class DetallePlatoViewModel : ViewModel() {

    private val viewmodelJob = Job()
    private val coroutineScope = CoroutineScope(viewmodelJob + Dispatchers.Main)

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

    override fun onCleared() {
        super.onCleared()
        viewmodelJob.cancel()
    }
}