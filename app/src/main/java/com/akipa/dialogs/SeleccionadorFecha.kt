package com.akipa.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.akipa.databinding.FragmentRecojoEnTiendaBinding
import java.util.*

class SeleccionadorFecha(private val binding: FragmentRecojoEnTiendaBinding) : DialogFragment(),
    DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val ano = calendar[Calendar.YEAR]
        val mes = calendar[Calendar.MONTH]
        val dia = calendar[Calendar.DAY_OF_MONTH]
        return DatePickerDialog(requireActivity(), this, ano, mes, dia)
    }

    override fun onDateSet(p0: DatePicker?, ano: Int, mes: Int, dia: Int) {
        binding.seleccionarFechaValor.text = "$dia de ${mesFromIndex(mes)} del $ano"
    }

    private fun mesFromIndex(mes: Int) =
        when (mes) {
            0 -> "Enero"
            1 -> "Febrero"
            2 -> "Marzo"
            3 -> "Abril"
            4 -> "Mayo"
            5 -> "Junio"
            6 -> "Julio"
            7 -> "Agosto"
            8 -> "Setiembre"
            9 -> "Octubre"
            10 -> "Noviembre"
            11 -> "Diciembre"
            else -> throw IndexOutOfBoundsException()
        }
}