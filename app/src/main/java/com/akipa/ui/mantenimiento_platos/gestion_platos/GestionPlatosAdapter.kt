package com.akipa.ui.mantenimiento_platos.gestion_platos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akipa.databinding.ItemGestionPlatoBinding
import com.akipa.entidades.Plato
import com.akipa.ui.lista_platos.ListaProductosDiffCallback

class GestionPlatosAdapter(private val clickListener: GestionPlatosListener) :
    ListAdapter<Plato, GestionPlatosAdapter.GestionPlatosViewHolder>(ListaProductosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GestionPlatosViewHolder =
        GestionPlatosViewHolder.from(parent)

    override fun onBindViewHolder(holder: GestionPlatosViewHolder, position: Int) {
        val plato = getItem(position)
        holder.bind(plato, clickListener)
    }

    class GestionPlatosViewHolder(private val binding: ItemGestionPlatoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plato: Plato, clickListener: GestionPlatosListener) {
            binding.plato = plato
            binding.listener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): GestionPlatosViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemGestionPlatoBinding.inflate(inflater, parent, false)
                return GestionPlatosViewHolder(binding)
            }
        }
    }

}

interface GestionPlatosListener {
    fun onEditarClick(plato: Plato)
    fun onEliminarClick(idPlato: Int)
}