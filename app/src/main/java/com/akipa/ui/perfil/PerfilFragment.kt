package com.akipa.ui.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.akipa.database.AkipaLocalDatabase
import com.akipa.databinding.FragmentPerfilBinding
import com.akipa.utils.Constantes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPerfilBinding.inflate(inflater)

        binding.personalLogueado = Constantes.personalAkipaLogueado

        binding.cerrarSesion.setOnClickListener { cerrarSesion() }

        return binding.root
    }

    private fun cerrarSesion() = lifecycleScope.launch(Dispatchers.IO) {
        Constantes.personalAkipaLogueado?.let {
            AkipaLocalDatabase.getInstance(requireActivity().applicationContext)
                .personalDao
                .cerrarSesion(it)
        }
        Constantes.personalAkipaLogueado = null
        withContext(Dispatchers.Main) {
            activity?.invalidateOptionsMenu()
            findNavController().navigate(PerfilFragmentDirections.actionPerfilFragmentToListaProductosFragment())
        }
    }
}