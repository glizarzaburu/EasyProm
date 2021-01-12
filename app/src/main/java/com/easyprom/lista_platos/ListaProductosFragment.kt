package com.easyprom.lista_platos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.easyprom.databinding.FragmentListaplatosBinding

class ListaProductosFragment : Fragment() {

    private val viewModel: ListaProductosViewModel by viewModels()
    private lateinit var binding: FragmentListaplatosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaplatosBinding.inflate(inflater, container, false)
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