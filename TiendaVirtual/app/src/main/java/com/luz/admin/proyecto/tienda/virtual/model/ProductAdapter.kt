package com.luz.admin.proyecto.tienda.virtual.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.luz.admin.proyecto.tienda.virtual.*

class ProductAdapter(val mCtx: Context, val layoutResId: Int, val productList: List<Product>)
    : ArrayAdapter<Product>(mCtx, layoutResId, productList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val txtViewTitulo= view.findViewById<TextView>(R.id.textViewTitulo)
        val txtViewDescripcion= view.findViewById<TextView>(R.id.textViewDescripcion)
        val txtViewPrecio= view.findViewById<TextView>(R.id.textViewPrecio)

        val product= productList[position]

        txtViewTitulo.text = product.titulo
        txtViewDescripcion.text = product.descripcion
        txtViewPrecio.text = product.precio.toString()

        return view;
    }
}