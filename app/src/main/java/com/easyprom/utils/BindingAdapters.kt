package com.easyprom.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.easyprom.entidades.Plato
import com.easyprom.lista_platos.ListaProductosAdapter

/**
 * Utilizado para indicarle la lista de platos a mostrar
 * en la pantalla principal de la app
 */
@BindingAdapter("listaDatos")
fun RecyclerView.bindRecyclerView(data: List<Plato>?) {
    val adapter = this.adapter as ListaProductosAdapter?
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
            //TODO: agregar placeholder y error acá eventualmente
            .into(this)
    }
}