package com.easyprom.lista_platos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyprom.entidades.Plato
import com.easyprom.network.AkipaAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "ListaProductosViewModel"

class ListaProductosViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _listadoPlatos = MutableLiveData<List<Plato>>()
    val listadoPlatos: LiveData<List<Plato>>
        get() = _listadoPlatos

    init {
        obtenerListadoPlatos()
    }

    private fun obtenerListadoPlatos() {

        coroutineScope.launch {
            val listadoDeferred = AkipaAPI.retrofitService.obtenerListadoPlatosAsync()
            try {
                val listadoPlatos = listadoDeferred.await()
                if (listadoPlatos.platos.isNotEmpty()) {
                    _listadoPlatos.value = listadoPlatos.platos
                }
                Log.i(TAG, listadoPlatos.toString())
            } catch (e: Exception) {
                // lista vacia en caso de no haber datos
                Log.i(TAG, e.toString())
                _listadoPlatos.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}