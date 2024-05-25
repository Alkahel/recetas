package com.example.recetascocina.Administrador
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recetascocina.MainActivity
import com.example.recetascocina.R
import com.example.recetascocina.databinding.ActivityLoginAdminBinding
import org.intellij.lang.annotations.Pattern
import com.google.firebase.auth.FirebaseAuth
class Login_Admin : AppCompatActivity() {
    private lateinit var binding: ActivityLoginAdminBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere por favor")
        progressDialog.setCanceledOnTouchOutside(false)
        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.BtnLoginAdmin.setOnClickListener {
            validarInformacion()
        }
    }

    private var email = ""
    private var password = ""
    private fun validarInformacion() {
        email = binding.EtEmailAdmin.text.toString().trim()
        password = binding.EtPasswordAdmin.text.toString().trim()
        if (email.isEmpty()) {
            binding.EtEmailAdmin.error = "Ingrese su correo"
            binding.EtEmailAdmin.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.EtEmailAdmin.error = "Correo inválido"
            binding.EtEmailAdmin.requestFocus()
        } else if (password.isEmpty()) {
            binding.EtEmailAdmin.error = "Ingrese la contraseña"
            binding.EtEmailAdmin.requestFocus()
        } else {
            LoginAdmin()
        }
    }

    private fun LoginAdmin() {
        progressDialog.setMessage("iniciando sesión")
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                progressDialog.dismiss()
                startActivity(Intent(this@Login_Admin, MainActivity::class.java))
                finishAffinity()
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(
                    applicationContext, "No su pudo iniciar sesión debido a ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}