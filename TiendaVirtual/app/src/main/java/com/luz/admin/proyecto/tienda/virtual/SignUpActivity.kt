package com.luz.admin.proyecto.tienda.virtual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.luz.admin.proyecto.tienda.virtual.room_database.usuario.Usuario
import com.luz.admin.proyecto.tienda.virtual.viewmodel.UsuarioViewModel

class SignUpActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private lateinit var usuarioViewModel: UsuarioViewModel
    var myDatasetProyecto = emptyList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

}