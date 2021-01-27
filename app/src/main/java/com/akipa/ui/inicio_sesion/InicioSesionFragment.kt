package com.akipa.ui.inicio_sesion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akipa.R

class InicioSesionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // temporal
        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false)
    }
}