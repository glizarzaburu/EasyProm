package com.easyprom.lista_productos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.easyprom.R
import com.easyprom.databinding.FragmentListaproductosBinding

class ListaProductosFragment : Fragment() {

    private val viewModel: ListaProductosViewModel by viewModels()
    private lateinit var binding: FragmentListaproductosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaproductosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = ListaProductosAdapter(ProductoListener { plato ->
            // acá manejaremos el evento de click. Por ahora un mensaje en consola
            println("El plato es $plato")
        })
        binding.productosLista.adapter = adapter

        return binding.root
    }
}