package com.example.guarderia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Mascota(val nombre: String, val raza: String, val tieneRuta: Boolean)


class MascotaAdapter(private val mascotas: List<Mascota>) :
    RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mascota, parent, false)
        return MascotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.bind(mascota)
    }

    override fun getItemCount(): Int {
        return mascotas.size
    }

    inner class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        private val textViewRaza: TextView = itemView.findViewById(R.id.textViewRaza)

        fun bind(mascota: Mascota) {
            textViewNombre.text = mascota.nombre
            textViewRaza.text = mascota.raza
        }
    }
}