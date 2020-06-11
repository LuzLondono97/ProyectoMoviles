package com.luz.admin.proyecto.tienda.virtual.room_database.compra

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Compra::class), version = 1, exportSchema = false)
public abstract class  CompraDatabase : RoomDatabase() {

    abstract fun compraDAO(): CompraDAO

    companion object {
        @Volatile
        private var INSTANCE: CompraDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): CompraDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CompraDatabase::class.java,
                    "compra_database"
                ).addCallback(CompraDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class CompraDatabaseCallback (
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase){
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.compraDAO())
                }
            }
        }

        suspend fun populateDatabase(compraDAO: CompraDAO) {
            //compraDAO.deleteAll()

            var compra = Compra(0,0, 0)
            compraDAO.insert(compra)
        }

    }

}