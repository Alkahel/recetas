package com.example.recetascocina.Fragmentos_Admin

import android.os.Bundle
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recetascocina.Administrador.Agregar_Categoria
import com.example.recetascocina.databinding.FragmentAdminDashboardBinding
import com.example.recetascocina.R
import java.math.MathContext


class Fragment_admin_dashboard : Fragment() {

    private lateinit var binding: FragmentAdminDashboardBinding
    private lateinit var mContext: Context


   override fun onAttach(context: Context){
       mContext = context
       super.onAttach(context)
   }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminDashboardBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
    override  fun onViewCreated(view: View,savedInstanceState: Bundle?){
        super.onViewCreated(view,savedInstanceState)

        binding.BtnAgregarCategoria.setOnClickListener{
            startActivity(Intent(mContext, Agregar_Categoria::class.java))
        }
        binding.AgregarPdf.setOnClickListener{

        }
    }

}