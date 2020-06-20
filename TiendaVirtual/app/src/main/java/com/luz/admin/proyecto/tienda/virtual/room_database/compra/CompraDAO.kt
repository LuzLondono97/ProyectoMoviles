package com.luz.admin.proyecto.tienda.virtual.room_database.compra

import androidx.lifecycle.LiveData
import androidx.room.*
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.Compra

@Dao
interface CompraDAO {

    @Query("SELECT * FROM compra_table ORDER BY productoID, usuarioID ASC")
    fun getAll(): LiveData<List<Compra>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(compra: Compra)

    @Delete()
    suspend fun deleteCompra(compra: Compra)

    @Query("DELETE FROM compra_table")
    suspend fun deleteAll()

}