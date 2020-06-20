package com.luz.admin.proyecto.tienda.virtual

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.luz.admin.proyecto.tienda.virtual.model.Product

class ProductoActivity : AppCompatActivity() {

    private lateinit var txtTitulo: EditText
    private lateinit var txtDescripcion: EditText
    private lateinit var txtPrecio: EditText
    private lateinit var buttonRegistrar: Button

    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        ref = FirebaseDatabase.getInstance().getReference("Producto")

        txtTitulo = findViewById(R.id.edtTxtTitulo)
        txtDescripcion = findViewById(R.id.edtTxtDescripcion)
        txtPrecio = findViewById(R.id.edtTxtPrecio)
        buttonRegistrar = findViewById(R.id.bttnRegistryProducto)

        buttonRegistrar.setOnClickListener{saveProducto()}
    }

    fun saveProducto(){
        val titulo: String = txtTitulo.text.toString()
        val descripcion: String = txtDescripcion.text.toString()
        val precio: Int = Integer.parseInt(txtPrecio.getText().toString().trim())

        if(TextUtils.isEmpty(titulo)){
            txtTitulo.error = "Debe digitar el campo Título"
            return
        }

        if(TextUtils.isEmpty(descripcion)){
            txtDescripcion.error = "Debe digitar el campo Descripción"
            return
        }

        if(precio == null || precio.equals("") ){
            txtPrecio.error = "Debe digitar el campo Precio"
            return
        }


        val productId = ref.push().key
        val product = Product(productId.toString(), titulo, descripcion, precio)

        ref.child(productId.toString()).setValue(product).addOnCompleteListener(this){
            Toast.makeText(applicationContext, "Producto Registrado con Exitó", Toast.LENGTH_LONG).show()
            txtTitulo.setText("")
            txtDescripcion.setText("")
            txtPrecio.setText("")
        }
    }

}