package com.luz.admin.proyecto.tienda.virtual.repository

import android.app.Application
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.Compra
import com.luz.admin.proyecto.tienda.virtual.room_database.TiendaDatabase

class CompraRepository(application: Application) {

    private val compraDAO = TiendaDatabase.getInstance(application).compraDAO()

    fun getAll() = compraDAO.getAll()

    suspend fun insert(compra: Compra) {
        compraDAO.insert(compra)
    }

    suspend fun deleteCompra(compra: Compra) {
        compraDAO.deleteCompra(compra)
    }

    suspend fun deleteAll() {
        compraDAO.deleteAll()
    }
}