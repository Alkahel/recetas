package com.example.recetascocina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recetascocina.Administrador.Registrar_Admin
import com.example.recetascocina.databinding.ActivityElegirRolBinding
import com.example.recetascocina.databinding.ActivityMainBinding

class Elegir_rol : AppCompatActivity() {

    private lateinit var binding: ActivityElegirRolBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElegirRolBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.BtnRolAdministrador.setOnClickListener{
            //Toast.makeText(applicationContext, "Rol administrador", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@Elegir_rol, Registrar_Admin::class.java))
        }
        binding.BtnRolCiente.setOnClickListener{
            Toast.makeText(applicationContext, "Rol cliente", Toast.LENGTH_SHORT).show()
        }
    }
}