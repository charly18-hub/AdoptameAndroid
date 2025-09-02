package com.example.adoptame.FragmentsFormatoAdopcion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.airbnb.lottie.LottieAnimationView
import com.example.adoptame.Activity.FormularioActivity
import com.example.adoptame.Cargando.CargandoActivity
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Desktop.DesktopCatsActivity
import com.example.adoptame.R

class FormularioFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_formulario, container, false)
        val siguiente: TextView = view.findViewById(R.id.siguiente1)
        siguiente.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                navDesktopActivity()
            }
        })
        return view
    }

    private fun navDesktopActivity(){
        val sharedPreferences = context?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val especieType = sharedPreferences?.getString("especieType", "")

        if(especieType.equals("1")){
            val intentFormatoAdopcion = Intent(activity, DesktopActivity::class.java)
            startActivity(intentFormatoAdopcion)
            activity?.finish()
        }
        if(especieType.equals("2")){
            val intentFormatoAdopcion = Intent(activity, DesktopCatsActivity::class.java)
            startActivity(intentFormatoAdopcion)
            activity?.finish()
        }
    }

}