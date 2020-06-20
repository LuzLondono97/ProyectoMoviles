package com.luz.admin.proyecto.tienda.virtual.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.luz.admin.proyecto.tienda.virtual.room_database.TiendaDatabase
import com.luz.admin.proyecto.tienda.virtual.room_database.producto.Producto

class ProductoRepository(application: Application) {

    private val productoDAO = TiendaDatabase.getInstance(application).productoDAO()
    val allProductos: LiveData<List<Producto>> = productoDAO.getAll()

    suspend fun insert(producto: Producto) {
        productoDAO.insert(producto)
    }

    suspend fun deleteProducto(producto: Producto) {
        productoDAO.deleteProducto(producto)
    }

    suspend fun deleteAll() {
        productoDAO.deleteAll()
    }
}