package com.example.guarderia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonMatricularMascota: Button
    private lateinit var buttonVerMisMascotas: Button
    private lateinit var buttonVerRutaMascota: Button
    private lateinit var buttonHacerPago: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        buttonMatricularMascota = findViewById(R.id.buttonMatricularMascota)
        buttonVerMisMascotas = findViewById(R.id.buttonVerMisMascotas)
        buttonVerRutaMascota = findViewById(R.id.buttonVerRutaMascota)
        buttonHacerPago = findViewById(R.id.buttonHacerPago)

        buttonMatricularMascota.setOnClickListener(this)
        buttonVerMisMascotas.setOnClickListener(this)
        buttonVerRutaMascota.setOnClickListener(this)
        buttonHacerPago.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonMatricularMascota -> {
                // Acción para matricular mascota
                startActivity(Intent(this, MatricularMascotaActivity::class.java))
            }

            R.id.buttonVerMisMascotas -> {
                // Acción para ver mis mascotas
                startActivity(Intent(this, VerMisMascotasActivity::class.java))
            }

            R.id.buttonVerRutaMascota -> {
                // Acción para ver ruta asociada a mascota
                startActivity(Intent(this, VerRutaMascotaActivity::class.java))
            }

            R.id.buttonHacerPago -> {
                // Acción para hacer pago
                startActivity(Intent(this, HacerPagoActivity::class.java))
            }
        }
    }
}