package com.luz.admin.proyecto.tienda.virtual.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.luz.admin.proyecto.tienda.virtual.repository.CompraRepository
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.Compra
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CompraViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: CompraRepository
    val allCompras: LiveData<List<Compra>>

    init {
        repository = CompraRepository(application, viewModelScope)
        allCompras = repository.allCompras
    }

    fun insert(compra: Compra){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(compra)
        }
    }

    fun deleteCompra(compra: Compra) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCompra(compra)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}