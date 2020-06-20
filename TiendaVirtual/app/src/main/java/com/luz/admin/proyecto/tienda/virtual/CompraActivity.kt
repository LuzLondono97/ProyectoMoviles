package com.luz.admin.proyecto.tienda.virtual

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.luz.admin.proyecto.tienda.virtual.model.Product
import com.luz.admin.proyecto.tienda.virtual.model.ProductAdapter

class CompraActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var productList: MutableList<Product>
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        productList = mutableListOf()
        listView = findViewById(R.id.productsListView)
        ref = FirebaseDatabase.getInstance().getReference("Producto")


        ref.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    for(h in p0.children){
                        val product = h.getValue(Product::class.java)
                        productList.add(product!!)
                    }
                    val adapter = ProductAdapter(this@CompraActivity, R.layout.productos, productList)
                    listView.adapter = adapter
                }
            }

        })
    }

}