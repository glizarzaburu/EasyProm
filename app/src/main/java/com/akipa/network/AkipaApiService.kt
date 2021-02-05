package com.akipa.network

import com.akipa.dto.ListadoPlatos
import com.akipa.dto.PersonalAutorizado
import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 * Interface donde estarán los servicios a consultar
 */
interface AkipaApiService {

    @GET("listarPlatos.php")
    fun obtenerListadoPlatosAsync(): Deferred<ListadoPlatos>

    @GET("inicioSesionPersonal.php")
    fun iniciarSesionAsync(
        @Query("usuario") usuario: String,
        @Query("contrasena") contrasena: String
    ): Deferred<PersonalAutorizado>
}