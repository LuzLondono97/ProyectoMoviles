package com.luz.admin.proyecto.tienda.virtual.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.luz.admin.proyecto.tienda.virtual.room_database.producto.Producto
import com.luz.admin.proyecto.tienda.virtual.room_database.producto.ProductoDatabase
import kotlinx.coroutines.CoroutineScope

class ProductoRepository(application: Application, viewModelScope: CoroutineScope) {

    private val productoDAO = ProductoDatabase.getDatabase(
        application,
        viewModelScope
    ).productoDAO()

    val allProductos: LiveData<List<Producto>> = productoDAO.getProductoByNombre()

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