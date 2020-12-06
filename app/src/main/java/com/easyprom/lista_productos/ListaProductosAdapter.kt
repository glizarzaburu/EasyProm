package com.easyprom.lista_productos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.easyprom.databinding.ItemProductoBinding
import com.easyprom.entidades.Producto

class ListaProductosAdapter(private val clickListener: ProductoListener) :
    ListAdapter<Producto, ListaProductosAdapter.ListaProductosViewHolder>(ListaProductosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaProductosViewHolder =
        ListaProductosViewHolder.from(parent)

    override fun onBindViewHolder(holder: ListaProductosViewHolder, position: Int) {
        val producto = getItem(position)
        holder.bind(producto, clickListener)
    }

    class ListaProductosViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(producto: Producto, clickListener: ProductoListener) {
            // eventualmente acá se pasará la info del producto para que aparezca en el layout
            // y el evento de click
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ListaProductosViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductoBinding.inflate(layoutInflater, parent, false)
                return ListaProductosViewHolder(binding)
            }
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

class ProductoListener(val clickListener: (producto: Producto) -> Unit) {
    fun onClick(producto: Producto) = clickListener(producto)
}