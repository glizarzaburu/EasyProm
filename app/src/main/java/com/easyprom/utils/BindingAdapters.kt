package com.easyprom.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.easyprom.entidades.Plato
import com.easyprom.lista_platos.ListaProductosAdapter

@BindingAdapter("listaDatos")
fun RecyclerView.bindRecyclerView(data: List<Plato>?) {
    val adapter = this.adapter as ListaProductosAdapter?
    adapter?.submitList(data)
}