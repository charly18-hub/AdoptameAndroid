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

class FormularioActivity : AppCompatActivity() {
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
    }

    private fun timeDialog(){
        //transicion a registro
        val tiempoTranscurrir = 1000 //1 segundo, 1000 millisegundos.
        val handler: Handler = Handler()
        handler.postDelayed(Runnable { //***Aquí agregamos el proceso a ejecutar.
            //showDefaultDialog()
            getSpecie()
        }, tiempoTranscurrir.toLong()) //define el tiempo.
    }
    private fun getSpecie(){

        val sharedPreferences = applicationContext?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val especieType = sharedPreferences?.getString("especieType", "")

        if(especieType.equals("1")){
            showDefaultDialog()
        }
        if(especieType.equals("2")){
            showDefaultDialogCat()
        }
    }

    private fun showDefaultDialog() {
        val alertDialog = AlertDialog.Builder(this)
        val inflater = this.layoutInflater;
        alertDialog.apply {
            setView(inflater.inflate(R.layout.dialog_alert1, null))
            setPositiveButton("Aceptar") { _: DialogInterface?, _: Int ->
            }
            setNegativeButton("Salir") { _, _ ->
                finish()
            }
            setOnDismissListener {
            }
        }.create().show()
    }


    private fun showDefaultDialogCat() {
        val alertDialog = AlertDialog.Builder(this)
        val inflater = this.layoutInflater;
        alertDialog.apply {
            setView(inflater.inflate(R.layout.dialog_alert1_cat, null))
            setPositiveButton("Aceptar") { _: DialogInterface?, _: Int ->
            }
            setNegativeButton("Salir") { _, _ ->
                finish()
            }
            setOnDismissListener {
            }
        }.create().show()
    }

    private fun contFragment(){
        //Creamos el fragmento
        val formFragment = FormularioFragment()
        //Pasamos los extras del intent al fragmento
        formFragment.arguments = intent.extras
        supportFragmentManager.beginTransaction()
            .add(R.id.contentFragmentFormat, formFragment).commit()
    }
}
