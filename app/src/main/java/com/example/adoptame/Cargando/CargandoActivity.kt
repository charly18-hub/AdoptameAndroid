package com.example.adoptame.Cargando

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.adoptame.Activity.SelectEspecieActivity
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.R

class CargandoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cargando)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lottieAnimate()
        transicion()
    }

    private fun lottieAnimate(){

        val lottieAnimationView: LottieAnimationView = findViewById(R.id.animation_view)
        // Para iniciar la animación
        lottieAnimationView.playAnimation()
        // Cuantas veces se reproducirá la animación (en este caso infinitas veces)
        lottieAnimationView.repeatCount =  LottieDrawable.INFINITE
        // Establecer la velocidad de reproducción
        lottieAnimationView.speed = 1.0f
        // Establecer el punto de inicio de la animación
        lottieAnimationView.progress = .5f

    }

    private fun transicion(){
        //transicion a registro
        val tiempoTranscurrir = 2000 //1 segundo, 1000 millisegundos.
        val handler: Handler = Handler()
        handler.postDelayed(Runnable { //***Aquí agregamos el proceso a ejecutar.
            val intent = Intent(
                applicationContext,
                DesktopActivity::class.java
            )
            startActivity(intent)
        }, tiempoTranscurrir.toLong()) //define el tiempo.
    }

}