package com.example.adoptame.Asociaciones

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAsociacion
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Modal.ModalAsociacion
import com.example.adoptame.R

class AsociacionesActivity : AppCompatActivity() {

    private lateinit var courseRV: RecyclerView
    private lateinit var courseRVAdapter: RecyclerAdapterAsociacion
    private lateinit var courseList: ArrayList<ModalAsociacion>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_asociaciones)

        // RecyclerView
        courseRV = findViewById(R.id.idRVCourses)
        courseRV.layoutManager = LinearLayoutManager(this)
        courseRV.setHasFixedSize(true)
        // Data
        courseList = ArrayList()

        // Adapter
        courseRVAdapter = RecyclerAdapterAsociacion(courseList, this)
        courseRV.adapter = courseRVAdapter

        Handler().postDelayed({


        courseList.add(
            ModalAsociacion(
                name = "Adopta Huellitas",
                city = "Monterrey",
                dogs = 34,
                cats = 12,
                logo = R.drawable.adopta_huellitas,
                verified = true
            )
        )

        courseList.add(
            ModalAsociacion(
                name = "Patitas de Amor",
                city = "CDMX",
                dogs = 10,
                cats = 8,
                logo = R.drawable.patitas_amor,
                verified = false
            )
        )
            courseRVAdapter.stopLoading()   // ← IMPORTANTE
            courseRVAdapter.notifyDataSetChanged() // ← ESTO FALTABA

        },1500)
    }

    /*private fun navHome() {

        val fab: View = findViewById(R.id.floatBack1)
        fab.setOnClickListener {
            goHome()
        }

        val btnBack: View = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            goHome()
        }
    }*/

    private fun goHome() {
        val intent = Intent(this, DesktopActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
