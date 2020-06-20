package com.luz.admin.proyecto.tienda.virtual.room_database.producto

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductoDAO {

    @Query("SELECT * FROM producto_table ORDER BY nombre, precio ASC")
    fun getAll(): LiveData<List<Producto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(producto: Producto)

    @Delete()
    suspend fun deleteProducto(producto: Producto)

    @Query("DELETE FROM producto_table")
    suspend fun deleteAll()

}