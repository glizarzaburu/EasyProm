package com.easyprom.lista_productos

import androidx.lifecycle.ViewModel
import com.easyprom.entidades.Producto

class ListaProductosViewModel : ViewModel() {

    // temporal. Eventualmente cambiar por la lista de productos real
    val listaProductos = listOf(
        Producto("leche", "rica"),
        Producto("harina", "fea")
    )

}