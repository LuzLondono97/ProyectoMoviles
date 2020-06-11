package com.luz.admin.proyecto.tienda.virtual.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.Compra
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.CompraDatabase
import kotlinx.coroutines.CoroutineScope

class CompraRepository(application: Application, viewModelScope: CoroutineScope) {

    private val compraDAO = CompraDatabase.getDatabase(
        application,
        viewModelScope
    ).compraDAO()

    val allCompras: LiveData<List<Compra>> = compraDAO.getCompraById()

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