package com.luz.admin.proyecto.tienda.virtual.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.luz.admin.proyecto.tienda.virtual.repository.UsuarioRepository
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: UsuarioRepository
    val allUsuarios: LiveData<List<Usuario>>

    init {
        repository = UsuarioRepository(application, viewModelScope)
        allUsuarios = repository.allUsuarios
    }

    fun insert(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(usuario)
        }
    }

    fun deleteUsuario(usuario: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUsuario(usuario)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}