package com.example.guarderia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (isValidCredentials(email, password)) {
                // Lógica para autenticar al usuario
                if (authenticateUser(email, password)) {
                    // Iniciar sesión exitosamente
                    showToast("Inicio de sesión exitoso")
                    // Navegar a la siguiente pantalla
                    // Intenta agregar tu código aquí para la navegación a la siguiente actividad
                } else {
                    // Credenciales inválidas
                    showToast("Credenciales inválidas")
                }
            } else {
                // Campos de entrada vacíos
                showToast("Ingrese su correo electrónico y contraseña")
            }
        }
    }
    private fun isValidCredentials(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

    private fun authenticateUser(email: String, password: String): Boolean {
        // Aquí debes implementar tu lógica de autenticación
        // Puedes realizar una llamada a una API, consultar una base de datos, etc.
        // Por simplicidad, este ejemplo considera que las credenciales son "admin" y "password"
        if(email == "admin" && password == "password"){
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish() // Opcional: Finaliza la actividad actual para que el usuario no pueda volver atrás con el botón de retroceso
            return true
        }
        return false
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}