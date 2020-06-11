package com.luz.admin.proyecto.tienda.virtual.room_database.usuario

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario_table")
class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "apellido")
    val apellido: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "clave")
    val clave: String
)