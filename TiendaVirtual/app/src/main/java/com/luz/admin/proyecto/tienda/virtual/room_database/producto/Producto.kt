package com.luz.admin.proyecto.tienda.virtual.room_database.producto

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "producto_table")
class Producto (
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    @ColumnInfo (name = "nombre")
    val nombre: String,
    @ColumnInfo (name = "descripcion")
    val descripcion: String,
    @ColumnInfo (name = "precio")
    val precio: Int/*,
    @ColumnInfo (name = "picture")
    val picture: Bitmap*/
)