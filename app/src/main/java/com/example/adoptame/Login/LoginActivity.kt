package com.example.adoptame.Login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.adoptame.Activity.FormularioActivity
import com.example.adoptame.Activity.SelectEspecieActivity
import com.example.adoptame.R
import com.example.adoptame.Registro.RegisterActivity

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin: TextView = findViewById(R.id.btnLogin)
            btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                navSelectEspecie()
            }
        })

        val btnRegister : TextView = findViewById(R.id.txtRegister)
        btnRegister.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                navRegisterActivity()
            }
        })
    }

    fun navRegisterActivity(){
        val intentRegister= Intent(applicationContext, RegisterActivity::class.java)
        startActivity(intentRegister)
    }



    fun navSelectEspecie(){
        val intentSelectEspecie= Intent(applicationContext, SelectEspecieActivity::class.java)
        startActivity(intentSelectEspecie)
        finish()
    }

}