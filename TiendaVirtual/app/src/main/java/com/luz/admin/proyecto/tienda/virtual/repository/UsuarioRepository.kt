package com.luz.admin.proyecto.tienda.virtual.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.luz.admin.proyecto.tienda.virtual.room_database.TiendaDatabase
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.Usuario

class UsuarioRepository(application: Application) {

    private val usuarioDAO = TiendaDatabase.getInstance(application).usuarioDAO()
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