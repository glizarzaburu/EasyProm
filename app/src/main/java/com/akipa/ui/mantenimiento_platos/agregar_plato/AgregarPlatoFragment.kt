package com.akipa.ui.mantenimiento_platos.agregar_plato

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.akipa.R
import com.akipa.databinding.FragmentAgregarPlatoBinding
import java.io.ByteArrayOutputStream

const val CAMERA_REQUEST_CODE = 777
const val CAMERA_PERMISSION_CODE = 17

class AgregarPlatoFragment : Fragment(R.layout.fragment_agregar_plato) {

    private lateinit var binding: FragmentAgregarPlatoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgregarPlatoBinding.inflate(inflater, container, false)

        binding.platoImagen.setOnClickListener { solicitarPermisoCamara() }

        return binding.root
    }

    private fun solicitarPermisoCamara() {
        if (!tienePermisoCamara()) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )
        } else {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                startActivityForResult(it, CAMERA_REQUEST_CODE)
            }
        }
    }

    /**
     * Devuelve verdadero si tenemos permiso para usar la camara.
     * Falso en caso contrario
     */
    private fun tienePermisoCamara(): Boolean =
        ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    private fun imagenToString(bitmap: Bitmap): String {
        ByteArrayOutputStream().also {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, it)
            val bytes = it.toByteArray()
            return Base64.encodeToString(bytes, Base64.DEFAULT)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                startActivityForResult(it, CAMERA_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val foto = data?.extras?.get("data") as Bitmap
            binding.platoImagen.setImageBitmap(foto)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}