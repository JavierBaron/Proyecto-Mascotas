package com.example.mascotas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class TipsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del fragmento
        val view = inflater.inflate(R.layout.fragment_tips, container, false)

        // Obtener las referencias de las CardView
        val cardView1 = view.findViewById<CardView>(R.id.cardView1)
        val cardView2 = view.findViewById<CardView>(R.id.cardView2)

        return view
    }
}
