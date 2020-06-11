package com.luz.admin.proyecto.tienda.virtual.room_database.producto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Producto::class), version = 1, exportSchema = false)
public abstract class ProductoDatabase : RoomDatabase() {

    abstract fun productoDAO(): ProductoDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductoDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ProductoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductoDatabase::class.java,
                    "producto_database"
                ).addCallback(ProductoDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class ProductoDatabaseCallback (
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase){
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.productoDAO())
                }
            }
        }

        suspend fun populateDatabase(productoDAO: ProductoDAO) {
            //productoDAO.deleteAll()

            var producto = Producto(0,"Vestido Rojo", "Nuevo, marca Studio F", 150000)
            productoDAO.insert(producto)
        }

    }

}