package com.example.guarderia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VerMisMascotasActivity : AppCompatActivity() {
    private lateinit var recyclerViewMascotas: RecyclerView
    private lateinit var mascotaAdapter: MascotaAdapter
    private val mascotasList: MutableList<Mascota> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_mis_mascotas)

        recyclerViewMascotas = findViewById(R.id.recyclerViewMascotas)
        mascotaAdapter = MascotaAdapter(mascotasList)

        recyclerViewMascotas.layoutManager = LinearLayoutManager(this)
        recyclerViewMascotas.adapter = mascotaAdapter

        // Lógica para obtener las mascotas del usuario actualmente
        obtenerMascotasUsuario()
    }

    private fun obtenerMascotasUsuario() {
        // Aquí puedes agregar tu lógica para obtener las mascotas del usuario, por ejemplo,
        // puedes realizar una consulta a una base de datos, llamar a una API, etc.

        // En este ejemplo, simplemente agregamos algunas mascotas de muestra
        mascotasList.add(Mascota("Firulais", "Labrador", true))
        mascotasList.add(Mascota("Luna", "Persa", false))
        mascotasList.add(Mascota("Max", "Golden Retriever", true))

        mascotaAdapter.notifyDataSetChanged()
    }
}