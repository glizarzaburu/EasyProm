package com.easyprom.lista_productos

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.easyprom.databinding.ItemProductoBinding
import com.easyprom.entidades.Producto

class ListaProductosAdapter :
    ListAdapter<Producto, ListaProductosAdapter.ListaProductosViewHolder>(ListaProductosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaProductosViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListaProductosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ListaProductosViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(producto: Producto) {
            // eventualmente acá se pasará la info del producto para que aparezca en el layout
            binding.executePendingBindings()
        }
    }

}

class ListaProductosDiffCallback : DiffUtil.ItemCallback<Producto>() {

    //TODO: Eventualmente cambiar por el criterio que indique que un item es el mismo
    // que otro. Probablemente por su ID
    override fun areItemsTheSame(oldItem: Producto, newItem: Producto): Boolean =
        oldItem.campo1 == newItem.campo1

    override fun areContentsTheSame(oldItem: Producto, newItem: Producto): Boolean =
        oldItem == newItem
}