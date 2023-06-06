package com.example.guarderia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class HacerPagoActivity : AppCompatActivity(){
    private lateinit var editTextPrecio: EditText
    private lateinit var editTextDetalle: EditText
    private lateinit var buttonPagar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hacer_pago)

        editTextPrecio = findViewById(R.id.editTextPrecio)
        editTextDetalle = findViewById(R.id.editTextDetalle)
        buttonPagar = findViewById(R.id.buttonPagar)

        buttonPagar.setOnClickListener {
            val precio = editTextPrecio.text.toString()
            val detalle = editTextDetalle.text.toString()
            val fecha = obtenerFechaActual()

            if (validarPago(precio, detalle)) {
                realizarPago(precio, detalle, fecha)
            } else {
                mostrarError("Por favor ingresa el precio y el detalle del pago.")
            }
        }
    }

    private fun obtenerFechaActual(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaActual = Calendar.getInstance().time
        return dateFormat.format(fechaActual)
    }

    private fun validarPago(precio: String, detalle: String): Boolean {
        return precio.isNotEmpty() && detalle.isNotEmpty()
    }

    private fun realizarPago(precio: String, detalle: String, fecha: String) {
        // Aquí puedes agregar la lógica para realizar el pago, como enviar los datos a un servidor o procesar un pago real.
        // En este ejemplo, simplemente mostraremos un mensaje de éxito con los detalles del pago.

        val mensaje = "Pago exitoso\n\nFecha: $fecha\nPrecio: $precio\nDetalle: $detalle"
        mostrarMensaje(mensaje)
    }

    private fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}