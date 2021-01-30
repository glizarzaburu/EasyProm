package com.akipa.ui.carrito

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akipa.databinding.FragmentCarritoBinding

private const val TAG = "CarritoFragment"

class CarritoFragment : Fragment(), OnClickItemsCarrito {

    private lateinit var binding: FragmentCarritoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarritoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val adapter = CarritoAdapter(this)
        binding.listaCarrito.adapter = adapter

        return binding.root
    }

    override fun onAgregarClick() {
        // temporal
        Log.i(TAG, "Hemos presionado agregar")
    }

    override fun onReducirClick() {
        // temporal
        Log.i(TAG, "Hemos presionado reducir")
    }
}