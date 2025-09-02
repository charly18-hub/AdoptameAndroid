package com.example.adoptame.Asociaciones

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAsociacion
import com.example.adoptame.Desktop.DesktopActivity
import com.example.adoptame.Modal.ModalAsociacion
import com.example.adoptame.R

class AsociacionesActivity : AppCompatActivity() {

    // on below line we are creating variables
    // for our swipe to refresh layout,
    // recycler view, adapter and list.
    lateinit var courseRV: RecyclerView
    lateinit var courseRVAdapter: RecyclerAdapterAsociacion
    lateinit var courseList: ArrayList<ModalAsociacion>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_asociaciones)
        // on below line we are initializing
        // our views with their ids.
        courseRV = findViewById(R.id.idRVCourses)

        // on below line we are initializing our list
        courseList = ArrayList()

        // on below line we are creating a variable
        // for our grid layout manager and specifying
        // column count as 2
        val layoutManager = GridLayoutManager(this, 2)

        courseRV.layoutManager = layoutManager

        // on below line we are initializing our adapter
        courseRVAdapter = RecyclerAdapterAsociacion(courseList, this)

        // on below line we are setting
        // adapter to our recycler view.
        courseRV.adapter = courseRVAdapter

        // on below line we are adding data to our list
        courseList.add(ModalAsociacion("Adopta Huellitas", R.drawable.adopta_huellitas))
        courseList.add(ModalAsociacion("Adopta un Angel", R.drawable.adopta_anegl))
        courseList.add(ModalAsociacion("Patitas de Amor", R.drawable.patitas_amor))
        courseList.add(ModalAsociacion("Zadrigman", R.drawable.zadrigman))
        courseList.add(ModalAsociacion("Adopta un Angel", R.drawable.adopta_anegl))

        // on below line we are notifying adapter
        // that data has been updated.
        courseRVAdapter.notifyDataSetChanged()

        navHome()
    }

    private fun navHome(){

        val fab: View = findViewById(R.id.floatBack1)
        fab.setOnClickListener { view ->

            val intentHome = Intent(this, DesktopActivity::class.java)
            intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intentHome)
            finish()


            }
        val btnBack: View = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intentHome = Intent(this, DesktopActivity::class.java)
            startActivity(intentHome)
            finish()
        }

    }
}
