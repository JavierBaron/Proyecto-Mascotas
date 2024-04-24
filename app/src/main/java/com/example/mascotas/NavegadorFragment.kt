package com.example.mascotas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class NavegadorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_navegador, container, false)

        // Inicializar WebView
        val webView: WebView = view.findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true

        // Deshabilitar la compatibilidad con la seguridad de la red
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            webView.settings.safeBrowsingEnabled = false
        }
        // Configurar el cliente web para que la navegación se realice dentro del WebView
        webView.webViewClient = WebViewClient()

        // Cargar una URL (por ejemplo, google.com)
        webView.loadUrl("https://www.google.com")

        return view
    }
}