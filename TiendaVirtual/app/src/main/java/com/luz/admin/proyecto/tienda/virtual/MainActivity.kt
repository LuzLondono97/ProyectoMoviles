package com.luz.admin.proyecto.tienda.virtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLogIn (view : View) {
        val enter = Intent(this, LoginActivity::class.java)
        startActivity(enter)
    }

    fun onSignUp (view : View) {
        val enter = Intent(this, SignUpActivity::class.java)
        startActivity(enter)
    }

}
