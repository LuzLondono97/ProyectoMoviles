package com.luz.admin.proyecto.tienda.virtual

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var edtTxtUser : EditText? = null
    private var edtTxtPassword : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtTxtUser = findViewById(R.id.edtTxtUser)
        edtTxtPassword = findViewById(R.id.edtTxtPassword)
    }

    fun onEnterLogin (view : View) {
        if(edtTxtUser!!.text.toString() == "luza0748@gmail.com") {
            if(edtTxtPassword!!.text.toString() == "123456789" ){
                val enter = Intent(this, HomeActivity::class.java)
                startActivity(enter)
            }
        }
    }

}