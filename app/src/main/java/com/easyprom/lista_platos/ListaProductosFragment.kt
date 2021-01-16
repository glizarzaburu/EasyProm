package com.easyprom.lista_platos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
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
            findNavController()
                .navigate(
                    ListaProductosFragmentDirections.actionListaProductosFragmentToDetallePlatoFragment(
                        plato
                    )
                )
        })
        binding.productosLista.adapter = adapter

        return binding.root
    }
}