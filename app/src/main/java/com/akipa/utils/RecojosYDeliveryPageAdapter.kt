package com.akipa.utils

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akipa.ui.carrito.pedido.DeliveryFragment
import com.akipa.ui.carrito.pedido.RecojoEnTiendaFragment

const val PEDIDOS_RECOJO_EN_TIENDA_INDEX = 0
const val PEDIDOS_DELIVERY = 1

class RecojosYDeliveryPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsPedidos = mapOf(
        PEDIDOS_RECOJO_EN_TIENDA_INDEX to { RecojoEnTiendaFragment() },
        PEDIDOS_DELIVERY to { DeliveryFragment() }
    )

    override fun getItemCount(): Int = tabFragmentsPedidos.size

    override fun createFragment(position: Int): Fragment =
        tabFragmentsPedidos[position]?.invoke() ?: throw IndexOutOfBoundsException()
}