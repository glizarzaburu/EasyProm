package com.akipa.ui.mantenimiento_platos.gestion_platos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akipa.databinding.FragmentGestionPlatosBinding

class GestionPlatosFragment : Fragment() {

    private lateinit var binding: FragmentGestionPlatosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGestionPlatosBinding.inflate(inflater, container, false)

        return binding.root
    }
}