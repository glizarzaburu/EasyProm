package com.akipa.ui.carrito.pedido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.akipa.R
import com.akipa.databinding.FragmentRecojoEnTiendaBinding
import com.akipa.dialogs.SeleccionadorFecha
import com.akipa.dialogs.SeleccionadorHora

class RecojoEnTiendaFragment : Fragment() {

    private lateinit var binding: FragmentRecojoEnTiendaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecojoEnTiendaBinding.inflate(inflater, container, false)

        binding.startTimerTrigger.setOnClickListener { seleccionarHora() }
        binding.startDateTrigger.setOnClickListener { seleccionarFecha() }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.akipa_locales,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.localSpinner.adapter = adapter
        }

        return binding.root
    }

    private fun seleccionarFecha() {
        SeleccionadorFecha(binding).show(parentFragmentManager, "datePicker")
    }

    private fun seleccionarHora() {
        SeleccionadorHora(binding).show(parentFragmentManager, "timePicker")
    }
}