package com.example.adoptame.Desktop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adoptame.Activity.FormularioActivity
import com.example.adoptame.Adoptados.AdoptadosActivity
import com.example.adoptame.Asociaciones.AsociacionesActivity
import com.example.adoptame.Eventos.EventosActivity
import com.example.adoptame.R

class DesktopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_desktop)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navAsociaciones()
        navAdoptados()
        navEventos()
    }

    private fun navAsociaciones(){

            val imgNavAsociacionesActivity : ImageButton=findViewById(R.id.asociaciones)
            imgNavAsociacionesActivity.setOnClickListener(View.OnClickListener {
            val intentNavAsociacion = Intent(applicationContext, AsociacionesActivity::class.java)
            startActivity(intentNavAsociacion)
            })
    }

    private fun navAdoptados(){

        val imgNavAdoptadosActivity : ImageButton=findViewById(R.id.adopciones)
        imgNavAdoptadosActivity.setOnClickListener(View.OnClickListener {
            val intentNavAdoptados = Intent(applicationContext, AdoptadosActivity::class.java)
            startActivity(intentNavAdoptados)
        })

    }

    private fun navEventos(){

        val imgEventos : ImageButton = findViewById(R.id.donaciones)
        imgEventos.setOnClickListener(View.OnClickListener {
            val intentNavEventos = Intent(applicationContext, EventosActivity::class.java)
            startActivity(intentNavEventos)
        })
    }

}