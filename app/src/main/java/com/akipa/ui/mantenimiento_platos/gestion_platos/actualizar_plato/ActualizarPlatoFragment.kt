package com.akipa.ui.mantenimiento_platos.gestion_platos.actualizar_plato

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.akipa.databinding.FragmentActualizarPlatoBinding

class ActualizarPlatoFragment : Fragment() {

    private lateinit var binding: FragmentActualizarPlatoBinding
    private val args: ActualizarPlatoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActualizarPlatoBinding.inflate(inflater, container, false)
        binding.plato = args.plato
        return binding.root
    }
}