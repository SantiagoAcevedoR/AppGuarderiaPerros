package com.example.guarderia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MatricularMascotaActivity : AppCompatActivity() {
    private lateinit var editTextNombreMascota: EditText
    private lateinit var editTextRazaMascota: EditText
    private lateinit var editTextTamanoMascota: EditText
    private lateinit var buttonMatricular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricular_mascota)

        editTextNombreMascota = findViewById(R.id.editTextNombreMascota)
        editTextRazaMascota = findViewById(R.id.editTextRazaMascota)
        editTextTamanoMascota = findViewById(R.id.editTextTamanoMascota)
        buttonMatricular = findViewById(R.id.buttonMatricular)

        buttonMatricular.setOnClickListener {
            val nombre = editTextNombreMascota.text.toString()
            val raza = editTextRazaMascota.text.toString()
            val tamano = editTextTamanoMascota.text.toString()

            if (isValidData(nombre, raza, tamano)) {
                // Lógica para matricular la mascota
                matricularMascota(nombre, raza, tamano)
            } else {
                // Campos de entrada vacíos
                showToast("Ingrese todos los campos requeridos")
            }
        }
    }

    private fun isValidData(nombre: String, raza: String, tamano: String): Boolean {
        return nombre.isNotEmpty() && raza.isNotEmpty() && tamano.isNotEmpty()
    }

    private fun matricularMascota(nombre: String, raza: String, tamano: String) {
        // Aquí puedes agregar tu lógica para matricular la mascota, por ejemplo,
        // puedes almacenar los datos en una base de datos, realizar una llamada a una API, etc.

        // En este ejemplo, simplemente mostramos un mensaje de éxito
        val mensaje = "Mascota matriculada:\nNombre: $nombre\nRaza: $raza\nTamaño: $tamano"
        showToast(mensaje)

        // Puedes agregar más acciones aquí, como navegar a la lista de mascotas matriculadas o
        // realizar alguna otra acción después de matricular la mascota
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}