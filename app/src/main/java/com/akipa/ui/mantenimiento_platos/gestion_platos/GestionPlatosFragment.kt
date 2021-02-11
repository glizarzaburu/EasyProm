package com.akipa.ui.mantenimiento_platos.gestion_platos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.akipa.databinding.FragmentGestionPlatosBinding
import com.akipa.entidades.Plato
import com.akipa.network.AkipaAPI
import com.akipa.ui.lista_platos.ListaProductosViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GestionPlatosFragment : Fragment(), GestionPlatosListener {

    private lateinit var binding: FragmentGestionPlatosBinding
    private val viewModel: ListaProductosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGestionPlatosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = GestionPlatosAdapter(this)
        binding.gestionPlatosListado.adapter = adapter

        return binding.root
    }

    override fun onEditarClick(plato: Plato) {
        findNavController().navigate(
            GestionPlatosFragmentDirections.actionGestionPlatosFragmentToActualizarPlatoFragment(
                plato
            )
        )
    }

    override fun onEliminarClick(idPlato: Int) =
        viewModel.eliminarPlato(idPlato)
}