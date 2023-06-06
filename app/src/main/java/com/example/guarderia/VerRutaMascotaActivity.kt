package com.example.guarderia

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerRutaMascotaActivity : AppCompatActivity() {

    private lateinit var textViewRuta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_ruta_mascota)

        textViewRuta = findViewById(R.id.textViewRuta)

        // Obtiene la mascota seleccionada de alguna forma
        val mascota = obtenerMascotaSeleccionada()

        // Verifica si la mascota tiene una ruta asociada
        if (mascota != null && mascota.tieneRuta) {
            val ruta = obtenerRutaMascota(mascota)
            val mensajeRuta = "Ruta de ${mascota.nombre}: $ruta"
            mostrarRuta(mensajeRuta)
        } else {
            mostrarSinRutaAsociada()
        }
    }

    private fun obtenerMascotaSeleccionada(): Mascota? {
        // Aquí debes implementar la lógica para obtener la mascota seleccionada.
        // Puedes obtenerla de una lista de mascotas, de una base de datos, de una API, etc.
        // En este ejemplo, asumimos que ya tienes la mascota seleccionada y la retornamos directamente.
        return Mascota("Firulais", "Labrador", true)
    }

    private fun obtenerRutaMascota(mascota: Mascota): String {
        // Aquí debes implementar la lógica para obtener la ruta asociada a la mascota.
        // Puedes obtenerla de una base de datos, de una API de servicios de geolocalización, etc.
        // En este ejemplo, simplemente retornamos una ruta de ejemplo estática.
        return "Latitud: 37.7749, Longitud: -122.4194"
    }

    private fun mostrarRuta(ruta: String) {
        textViewRuta.text = ruta
    }

    private fun mostrarSinRutaAsociada() {
        textViewRuta.text = "No hay ruta asociada a esta mascota."
    }

}