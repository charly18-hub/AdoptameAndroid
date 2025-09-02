package com.example.adoptame.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.adoptame.R

class SelectEspecieActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_select_especie)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        initDog()
        initCat()
    }

    private fun initDog(){
        val lottieAnimationDog: ImageView = findViewById(R.id.imageViewDog)
        lottieAnimationDog.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                navFormatoAdopcionDog()
            }
        })
    }

    private fun initCat(){
        val lottieAnimationCat: ImageView = findViewById(R.id.imageViewCat)
        lottieAnimationCat.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                navFormatoAdopcionCat()
            }
        })
    }

    private fun navFormatoAdopcionDog(){
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("especieType","1")
        editor.commit()
        val intentFormatoAdopcion = Intent(applicationContext, FormularioActivity::class.java)
        startActivity(intentFormatoAdopcion)
        finish()
    }

    private fun navFormatoAdopcionCat(){
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("especieType","2")
        editor.commit()
        val intentFormatoAdopcion = Intent(applicationContext, FormularioActivity::class.java)
        startActivity(intentFormatoAdopcion)
        finish()
    }
}