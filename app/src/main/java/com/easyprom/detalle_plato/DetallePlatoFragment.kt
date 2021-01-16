package com.easyprom.detalle_plato

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.easyprom.databinding.FragmentDetallePlatoBinding

class DetallePlatoFragment : Fragment() {

    private lateinit var binding: FragmentDetallePlatoBinding
    private val args: DetallePlatoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetallePlatoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.plato = args.plato

        return binding.root
    }
}