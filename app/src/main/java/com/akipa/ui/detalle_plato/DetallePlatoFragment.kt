package com.akipa.ui.detalle_plato

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.akipa.databinding.FragmentDetallePlatoBinding

class DetallePlatoFragment : Fragment() {

    private lateinit var binding: FragmentDetallePlatoBinding
    private val args: DetallePlatoFragmentArgs by navArgs()
    private val viewModel: DetallePlatoViewModel by viewModels(factoryProducer = {
        DetallePlatoViewModel.DetallePlatoViewModelFactory(requireActivity().application)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetallePlatoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.plato = args.plato

        viewModel.navegacionAlListadoPlatos.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(DetallePlatoFragmentDirections.actionDetallePlatoFragmentToListaProductosFragment())
                viewModel.navegacionAlListadoPlatosTerminada()
            }
        }

        return binding.root
    }
}