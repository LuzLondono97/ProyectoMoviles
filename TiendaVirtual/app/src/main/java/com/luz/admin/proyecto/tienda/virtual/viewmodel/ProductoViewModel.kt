package com.luz.admin.proyecto.tienda.virtual.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.luz.admin.proyecto.tienda.virtual.repository.ProductoRepository
import com.luz.admin.proyecto.tienda.virtual.room_database.producto.Producto

class ProductoViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: ProductoRepository
    val allProductos: LiveData<List<Producto>>

    init {
        repository = ProductoRepository(application, viewModelScope)
        allProductos = repository.allProductos
    }

    fun insert(producto: Producto){
        //viewModelScope
    }

}