package com.akipa.utils

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.akipa.R
import com.akipa.database.PlatoEnCarrito
import com.akipa.entidades.Plato
import com.akipa.ui.carrito.CarritoAdapter
import com.akipa.ui.lista_platos.EstadoListadoPlatos
import com.akipa.ui.lista_platos.ListaProductosAdapter

/**
 * Utilizado para indicarle la lista de platos a mostrar
 * en la pantalla principal de la app
 */
@BindingAdapter("listaPlatos")
fun RecyclerView.bindRecyclerView(data: List<Plato>?) {
    val adapter = this.adapter as ListaProductosAdapter?
    adapter?.submitList(data)
}

/**
 * Utilizado para indicarle la lista de platos agregados
 * al carrito
 */
@BindingAdapter("listaPlatosEnCarrito")
fun RecyclerView.bindPlatosEnCarrito(data: List<PlatoEnCarrito>?) {
    val adapter = this.adapter as CarritoAdapter?
    adapter?.submitList(data)
}

/**
 * Utilizado para mostrar imagenes. Solo requiere que se le
 * pase la URL de la misma
 */
@BindingAdapter("url_imagen")
fun ImageView.bingImage(imgUrl: String?) {
    imgUrl?.let { url ->
        val imgUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(this.context)
            .load(imgUri)
            .centerCrop()
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    } ?: run {
        Glide.with(this.context)
            .load(R.drawable.ic_broken_image)
            .centerCrop()
            .into(this)
    }
}

/**
 * Se encargará de renderizar distintas imagenes en base
 * al estado actual de los platos
 */
@BindingAdapter("estado_platos")
fun ImageView.statusPlatos(estado: EstadoListadoPlatos?) {
    when (estado) {
        EstadoListadoPlatos.CARGANDO -> {
            visibility = View.VISIBLE
            setImageResource(R.drawable.loading_animation)
        }
        EstadoListadoPlatos.ERROR -> {
            visibility = View.VISIBLE
            setImageResource(R.drawable.ic_connection_error)
        }
        EstadoListadoPlatos.LISTO -> visibility = View.GONE
    }
}