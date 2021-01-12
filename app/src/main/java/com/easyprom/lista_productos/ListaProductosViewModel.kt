package com.easyprom.lista_productos

import androidx.lifecycle.ViewModel
import com.easyprom.entidades.Plato

class ListaProductosViewModel : ViewModel() {

    // temporal. Eventualmente cambiar por la lista de productos real
    val listaProductos = listOf(
        Plato(1, "leche", 10.2),
        Plato(2, "ceviche", 15.5),
        Plato(3, "calamares", 19.5)
    )

}