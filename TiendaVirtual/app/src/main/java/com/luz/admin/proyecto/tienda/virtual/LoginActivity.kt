package com.luz.admin.proyecto.tienda.virtual

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var txtUser : EditText
    private lateinit var txtPassword : EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtUser = findViewById(R.id.edtTxtUser)
        txtPassword = findViewById(R.id.edtTxtPassword)

        progressBar = findViewById(R.id.progressBar)
        auth = FirebaseAuth.getInstance()
    }

    fun onEnterLogin (view : View) {
        loginUser()
    }

    fun forgotPassword(view: View){
        startActivity(Intent(this, ForgotPassActivity::class.java))
    }

    fun register(view: View){
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    private fun loginUser(){
        val user: String = txtUser.text.toString()
        val password: String = txtPassword.text.toString()

        if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)){
            progressBar.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(user, password)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isComplete){
                        //lo manda al login
                        action()
                    } else {
                        Toast.makeText(this, "Error en la autenticación", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun action(){
        startActivity(Intent(this, HomeActivity::class.java))
    }

}