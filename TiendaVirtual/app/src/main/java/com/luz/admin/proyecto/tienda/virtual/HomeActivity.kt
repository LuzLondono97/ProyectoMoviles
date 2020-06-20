package com.luz.admin.proyecto.tienda.virtual

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_search ->{
                Toast.makeText(applicationContext, "click on share", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_exit ->{
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onProducto (view : View) {
        val enter = Intent(this, ProductoActivity::class.java)
        startActivity(enter)
    }

    fun onCompra (view : View) {
        val enter = Intent(this, CompraActivity::class.java)
        startActivity(enter)
    }

    fun onCerrarSesion (view : View) {
        val enter = Intent(this, LoginActivity::class.java)
        startActivity(enter)
    }

}