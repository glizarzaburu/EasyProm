package com.akipa.network

import com.akipa.dto.ListadoPlatos
import com.akipa.dto.PersonalAutorizado
import com.akipa.dto.PlatoRegistradoResponse
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

    @FormUrlEncoded
    @POST("registrarPlato.php")
    fun registrarPlatoAsync(
        @Field("nombre") nombre: String,
        @Field("precio") precio: Double,
        @Field("foto") foto: String,
        @Field("descripcion") descripcion: String?
    ): Deferred<PlatoRegistradoResponse>

    @FormUrlEncoded
    @POST("actualizarPlato.php")
    fun actualizarPlatoAsync(
        @Field("id") id: Int,
        @Field("nombre") nombre: String,
        @Field("precio") precio: Double,
        @Field("foto") foto: String,
        @Field("descripcion") descripcion: String?
    ): Deferred<PlatoRegistradoResponse>

    @FormUrlEncoded
    @POST("eliminarPlato.php")
    fun eliminarPlatoAsync(@Field("id") id: Int): Deferred<PlatoRegistradoResponse>
}