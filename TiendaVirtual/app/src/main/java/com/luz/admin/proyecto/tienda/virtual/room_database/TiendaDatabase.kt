package com.luz.admin.proyecto.tienda.virtual.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.Compra
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.CompraDAO
import com.luz.admin.proyecto.tienda.virtual.room_database.producto.Producto
import com.luz.admin.proyecto.tienda.virtual.room_database.producto.ProductoDAO
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.Usuario
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.UsuarioDAO

@Database(
    entities = [Compra::class, Usuario::class, Producto::class],
    version = 1,
    exportSchema = false
)
abstract class TiendaDatabase : RoomDatabase() {

    abstract fun compraDAO(): CompraDAO
    abstract fun productoDAO(): ProductoDAO
    abstract fun usuarioDAO(): UsuarioDAO

    companion object {

        @Volatile
        private var INSTANCE: TiendaDatabase? = null

        fun getInstance(context: Context): TiendaDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TiendaDatabase::class.java,
                    "tienda_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}