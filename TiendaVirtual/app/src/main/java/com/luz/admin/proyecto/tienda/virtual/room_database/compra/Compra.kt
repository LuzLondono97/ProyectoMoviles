package com.luz.admin.proyecto.tienda.virtual.room_database.compra

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "compra_table")
class Compra (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "productoID")
    val productoID: Int,
    @ColumnInfo(name = "usuarioID")
    val usuarioID: Int
)