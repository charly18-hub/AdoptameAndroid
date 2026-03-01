package com.example.adoptame.Activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Desktop.DesktopCatsActivity
import com.example.adoptame.FragmentsFormatoAdopcion.FormularioFragment
import com.example.adoptame.R
import com.example.adoptame.utils.DialogsUtilsClass

class FormularioActivity : AppCompatActivity() {
    lateinit var dialogFormato : DialogsUtilsClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        timeDialog()
        contFragment()
        initDialog()
    }

    fun initDialog(){
        dialogFormato = DialogsUtilsClass()
    }

    private fun timeDialog(){
        val tiempoTranscurrir = 1000
        val handler: Handler = Handler()
        handler.postDelayed(Runnable {
            getSpecie()
        }, tiempoTranscurrir.toLong())
    }

    private fun getSpecie(){
        val sharedPreferences = applicationContext?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val especieType = sharedPreferences?.getString("especieType", "")
        if(especieType.equals("1")){
            dialogFormato.showDialogDog(this)
        }
        if(especieType.equals("2")){
            dialogFormato.showDialogCat(this)
        }
    }

    private fun contFragment(){
        val formFragment = FormularioFragment()
        formFragment.arguments = intent.extras
        supportFragmentManager.beginTransaction()
            .add(R.id.contentFragmentFormat, formFragment).commit()
    }
}
