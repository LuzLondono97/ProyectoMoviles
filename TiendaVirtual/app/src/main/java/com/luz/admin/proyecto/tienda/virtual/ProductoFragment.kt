package com.luz.admin.proyecto.tienda.virtual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.luz.admin.proyecto.tienda.virtual.room_database.producto.Producto
import com.luz.admin.proyecto.tienda.virtual.viewmodel.ProductoViewModel

import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration

class ProductoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private lateinit var proyectoViewModel: ProductoViewModel
    var myDatasetProyecto = emptyList<Producto>()

    override fun onCreateView
                (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val root = inflater.inflate(R.layout.activity_producto, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       // val edtTxtTitulo = activity?.findViewById<Action>(R.id.edtTxtTitulo)

        //proyectoViewModel = ViewModelProvider(this.view).get(ProductoViewModel::class.java)

        //viewAdapter = MyListAdapter(myDatasetProyecto, proyectoViewModel)
        recyclerView = requireView().findViewById(R.id.edtTxtTitulo)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = viewAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }


}