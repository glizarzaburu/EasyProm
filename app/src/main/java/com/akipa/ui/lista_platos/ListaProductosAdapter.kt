package com.akipa.ui.lista_platos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akipa.databinding.ItemPlatoBinding
import com.akipa.entidades.Plato

class ListaProductosAdapter(private val clickListener: ProductoListener) :
    ListAdapter<Plato, ListaProductosAdapter.ListaProductosViewHolder>(ListaProductosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaProductosViewHolder =
        ListaProductosViewHolder.from(parent)

    override fun onBindViewHolder(holder: ListaProductosViewHolder, position: Int) {
        val producto = getItem(position)
        holder.bind(producto, clickListener)
    }

    class ListaProductosViewHolder(private val binding: ItemPlatoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plato: Plato, clickListener: ProductoListener) {
            binding.plato = plato
            binding.listener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ListaProductosViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPlatoBinding.inflate(layoutInflater, parent, false)
                return ListaProductosViewHolder(binding)
            }
        }
    }

}

class ListaProductosDiffCallback : DiffUtil.ItemCallback<Plato>() {

    //TODO: Eventualmente cambiar por el criterio que indique que un item es el mismo
    // que otro. Probablemente por su ID
    override fun areItemsTheSame(oldItem: Plato, newItem: Plato): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Plato, newItem: Plato): Boolean =
        oldItem == newItem
}

class ProductoListener(val clickListener: (plato: Plato) -> Unit) {
    fun onClick(plato: Plato) = clickListener(plato)
}