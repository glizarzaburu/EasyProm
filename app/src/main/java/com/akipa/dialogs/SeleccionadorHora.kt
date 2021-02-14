package com.akipa.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.akipa.databinding.FragmentRecojoEnTiendaBinding
import java.util.*

class SeleccionadorHora(private val binding: FragmentRecojoEnTiendaBinding) : DialogFragment(),
    TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendario = Calendar.getInstance()
        val hora = calendario[Calendar.HOUR]
        val minuto = calendario[Calendar.MINUTE]
        return TimePickerDialog(activity, this, hora, minuto, false)
    }

    override fun onTimeSet(p0: TimePicker?, hora: Int, minuto: Int) {
        val time = horaFromHora(hora)
        binding.seleccionarHoraValor.text = "${time.first}:$minuto ${time.second}"
    }

    private fun horaFromHora(hora: Int) =
        when (hora) {
            0 -> "12" to "am"
            1 -> "1" to "am"
            2 -> "2" to "am"
            3 -> "3" to "am"
            4 -> "4" to "am"
            5 -> "5" to "am"
            6 -> "6" to "am"
            7 -> "7" to "am"
            8 -> "8" to "am"
            9 -> "9" to "am"
            10 -> "10" to "am"
            11 -> "11" to "am"
            12 -> "12" to "pm"
            13 -> "1" to "pm"
            14 -> "2" to "pm"
            15 -> "3" to "pm"
            16 -> "4" to "pm"
            17 -> "5" to "pm"
            18 -> "6" to "pm"
            19 -> "7" to "pm"
            20 -> "8" to "pm"
            21 -> "9" to "pm"
            22 -> "10" to "pm"
            23 -> "11" to "pm"
            else -> throw IndexOutOfBoundsException()
        }
}