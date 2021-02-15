package com.akipa.ui.lista_platos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akipa.databinding.ItemPlatoBinding
import com.akipa.entidades.Plato

class ListaPlatosAdapter(private val clickListener: ListaPlatosListener) :
    ListAdapter<Plato, ListaPlatosAdapter.ListaProductosViewHolder>(ListaPlatosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaProductosViewHolder =
        ListaProductosViewHolder.from(parent)

    override fun onBindViewHolder(holder: ListaProductosViewHolder, position: Int) {
        val producto = getItem(position)
        holder.bind(producto, clickListener)
    }

    class ListaProductosViewHolder(private val binding: ItemPlatoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plato: Plato, clickListener: ListaPlatosListener) {
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

class ListaPlatosDiffCallback : DiffUtil.ItemCallback<Plato>() {

    override fun areItemsTheSame(oldItem: Plato, newItem: Plato): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Plato, newItem: Plato): Boolean =
        oldItem == newItem
}

class ListaPlatosListener(val clickListener: (plato: Plato) -> Unit) {
    fun onClick(plato: Plato) = clickListener(plato)
}