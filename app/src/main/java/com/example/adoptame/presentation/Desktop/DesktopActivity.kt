package com.example.adoptame.presentation.Desktop

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adoptame.presentation.Adoptados.view.AdoptadosActivity
import com.example.adoptame.presentation.Asociaciones.view.AsociacionesActivity
import com.example.adoptame.presentation.Eventos.view.EventosActivity
import com.example.adoptame.R

class DesktopActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            DesktopScreen(
                onAdopciones = {
                    startActivity(Intent(this, AdoptadosActivity::class.java))
                },
                onAsociaciones = {
                    startActivity(Intent(this, AsociacionesActivity::class.java))
                },
                onEventos = {
                    startActivity(Intent(this, EventosActivity::class.java))
                }
            )
        }
    }
}
