package com.akipa.ui.mantenimiento_platos.gestion_platos.actualizar_plato

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.akipa.databinding.FragmentActualizarPlatoBinding
import com.akipa.dto.request.PlatoActualizarRequest
import com.akipa.utils.Constantes
import java.io.ByteArrayOutputStream

class ActualizarPlatoFragment : Fragment() {

    private lateinit var binding: FragmentActualizarPlatoBinding
    private val viewModel: ActualizarPlatoViewModel by viewModels()
    private val args: ActualizarPlatoFragmentArgs by navArgs()
    private lateinit var fotoBitmap: Bitmap
    private var imagenFueCambiada = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActualizarPlatoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.plato = args.plato
        binding.editarPlatoBoton.setOnClickListener { actualizarPlato() }

        viewModel.platoActualizadoResultado.observe(viewLifecycleOwner) {
            if (it == Constantes.PLATO_ACTUALIZADO_MENSAJE_EXITOSO) {
                findNavController().navigate(ActualizarPlatoFragmentDirections.actionActualizarPlatoFragmentToGestionPlatosFragment())
                viewModel.actualizarPlatoTerminado()
            }
        }

        return binding.root
    }

    // TODO: Validaciones pendientes
    private fun actualizarPlato() {
        val id = args.plato.id
        val nombre = binding.nombrePlatoInput.text.toString()
        val precio = binding.precioPlatoInput.text.toString().toDouble()
        val descripcion = binding.descripcionPlatoInput.text.toString()
        val foto =
            if (imagenFueCambiada) imagenToString(fotoBitmap) else Constantes.IMAGEN_NO_ACTUALIZADA
        val plato = PlatoActualizarRequest(id, nombre, precio, foto, descripcion)
        viewModel.actualizarPlato(plato)
    }

    private fun imagenToString(bitmap: Bitmap): String {
        ByteArrayOutputStream().also {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, it)
            val bytes = it.toByteArray()
            return Base64.encodeToString(bytes, Base64.DEFAULT)
        }
    }
}