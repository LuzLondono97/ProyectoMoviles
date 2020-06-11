package com.luz.admin.proyecto.tienda.virtual.room_database.usuario

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Usuario::class), version = 1, exportSchema = false)
public abstract class  UsuarioDatabase : RoomDatabase() {

    abstract fun usuarioDAO(): UsuarioDAO

    companion object {
        @Volatile
        private var INSTANCE: UsuarioDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UsuarioDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsuarioDatabase::class.java,
                    "usuario_database"
                ).addCallback(UsuarioDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class UsuarioDatabaseCallback (
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase){
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.usuarioDAO())
                }
            }
        }

        suspend fun populateDatabase(usuarioDAO: UsuarioDAO) {
            //usuarioDAO.deleteAll()

            var usuario = Usuario(0,"Luz Andrea", "Londoño", "luza0748@gmail.com", "123456789")
            usuarioDAO.insert(usuario)
        }

    }

}