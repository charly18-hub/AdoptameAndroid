package com.example.adoptame.Registro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adoptame.Activity.SelectEspecieActivity
import com.example.adoptame.R

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnLogin: TextView = findViewById(R.id.txtRegistrar)
        btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                navSelectEspecie()
            }
        })
    }

    fun navSelectEspecie(){
        val intentSelectEspecie= Intent(applicationContext, SelectEspecieActivity::class.java)
        startActivity(intentSelectEspecie)
        finish()
    }
}