package com.example.mascotas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class BotonesFuncionamiento : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_botones_funcionamiento, container, false)

        val btnPresionar: Button = view.findViewById(R.id.btnMostrarMensaje)
        val btnText : Button = view.findViewById(R.id.btnGenerarTexto)
        val textViewResultado : TextView = view.findViewById(R.id.textViewResultado)

        btnPresionar.setOnClickListener {
            Toast.makeText(requireContext(), "¡Botón presionado!", Toast.LENGTH_SHORT).show()
        }

        btnText.setOnClickListener {
            // Cambiar el texto del TextView cuando se presione el botón
            textViewResultado.text = "¡Texto generado!"
        }





        return view
    }

}