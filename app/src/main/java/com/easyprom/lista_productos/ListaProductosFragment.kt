package com.easyprom.lista_productos

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.easyprom.R
import com.easyprom.databinding.FragmentListaproductosBinding

class ListaProductosFragment : Fragment(R.layout.fragment_listaproductos) {

    private val viewModel: ListaProductosViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = FragmentListaproductosBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = ListaProductosAdapter(ProductoListener { producto ->
            // acá manejaremos el evento de click. Por ahora un mensaje en consola
            println("El producto es $producto")
        })
        binding.productosLista.adapter = adapter
    }
}