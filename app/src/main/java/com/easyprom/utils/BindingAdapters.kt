package com.easyprom.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.easyprom.entidades.Producto
import com.easyprom.lista_productos.ListaProductosAdapter

@BindingAdapter("listaDatos")
fun RecyclerView.bindRecyclerView(data: List<Producto>?) {
    val adapter = this.adapter as ListaProductosAdapter?
    adapter?.submitList(data)
}