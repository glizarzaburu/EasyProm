package com.akipa.network

import com.akipa.dto.ListadoPlatos
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Interface donde estarán los servicios a consultar
 */
interface AkipaApiService {

    @GET("listarPlatos.php")
    fun obtenerListadoPlatosAsync(): Deferred<ListadoPlatos>

}