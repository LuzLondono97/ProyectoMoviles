package com.luz.admin.proyecto.tienda.virtual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.luz.admin.proyecto.tienda.virtual.room_database.compra.Compra
import com.luz.admin.proyecto.tienda.virtual.viewmodel.CompraViewModel

class CompraFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private lateinit var compraViewModel: CompraViewModel
    var myDatasetProyecto = emptyList<Compra>()

    override fun onCreateView
                (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val root = inflater.inflate(R.layout.activity_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    /*fun getProductos(productos: List<Producto>){
        val total = 0
        for(producto: 0 in productos.size){
            total = total + productos.get(i).getPrecio()
        }
        return total
    }*/

}