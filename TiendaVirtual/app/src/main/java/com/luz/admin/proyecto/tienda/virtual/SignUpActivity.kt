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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtLastName: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        txtName = findViewById(R.id.edtTxtNombres)
        txtLastName = findViewById(R.id.edtTxtApellidos)
        txtEmail = findViewById(R.id.edtTxtEmail)
        txtPassword = findViewById(R.id.edtTxtPassword)

        progressBar = findViewById(R.id.progressBar)
        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        dbReference = database.reference.child("User")
    }

    fun register(view : View){
        createNewAccount()
    }

    private fun createNewAccount(){
        val name: String = txtName.text.toString()
        val lastName: String = txtLastName.text.toString()
        val email: String = txtEmail.text.toString()
        val password: String = txtPassword.text.toString()

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            progressBar.visibility = View.VISIBLE
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isComplete){
                        val user: FirebaseUser?= auth.currentUser
                        verifyEmail(user)

                        val userDB = dbReference.child(user?.uid.toString())
                        userDB.child("Name").setValue(name)
                        userDB.child("LastName").setValue(lastName)

                        //mandamos al usuario al login si es ok
                        action()
                    }
                }
        }
    }

    private fun action(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun verifyEmail(user: FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                task ->
                if(task.isComplete){
                    Toast.makeText(this, "Email enviado", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error al enviar el email", Toast.LENGTH_LONG).show()
                }
            }
    }

}