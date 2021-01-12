package com.easyprom.network

import com.easyprom.entidades.Plato
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Interface donde estarán los servicios a consultar
 */
interface AkipaApiService {

    @GET("listarPlatos.php")
    fun obtenerListadoPlatosAsync(): Deferred<List<Plato>>

}