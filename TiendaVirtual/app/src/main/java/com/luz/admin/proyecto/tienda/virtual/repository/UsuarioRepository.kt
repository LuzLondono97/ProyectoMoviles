package com.luz.admin.proyecto.tienda.virtual.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.Usuario
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.UsuarioDatabase
import kotlinx.coroutines.CoroutineScope

class UsuarioRepository(application: Application, viewModelScope: CoroutineScope) {

    private val usuarioDAO = UsuarioDatabase.getDatabase(
        application,
        viewModelScope
    ).usuarioDAO()

    val allUsuarios: LiveData<List<Usuario>> = usuarioDAO.getUsuarioByNombre()

    suspend fun insert(usuario: Usuario) {
        usuarioDAO.insert(usuario)
    }

    suspend fun deleteUsuario(usuario: Usuario) {
        usuarioDAO.deleteUsuario(usuario)
    }

    suspend fun deleteAll() {
        usuarioDAO.deleteAll()
    }

}