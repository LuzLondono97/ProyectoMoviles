package com.luz.admin.proyecto.tienda.virtual.room_database.usuario

import androidx.lifecycle.LiveData
import androidx.room.*
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.Usuario

@Dao
interface UsuarioDAO {

    @Query("SELECT * FROM usuario_table ORDER BY nombre ASC")
    fun getUsuarioByNombre(): LiveData<List<Usuario>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(usuario: Usuario)

    @Delete()
    suspend fun deleteUsuario(usuario: Usuario)

    @Query("DELETE FROM usuario_table")
    suspend fun deleteAll()

}