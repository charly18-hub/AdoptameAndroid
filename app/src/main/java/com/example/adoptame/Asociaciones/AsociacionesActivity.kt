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
import com.example.adoptame.utils.GetDataClass
import com.example.adoptame.utils.ShimmerClass

class AsociacionesActivity : AppCompatActivity() {

    private lateinit var asociacionRV: RecyclerView
    private lateinit var asociacionRVAdapter: RecyclerAdapterAsociacion
    private lateinit var asociacionList: ArrayList<ModalAsociacion>
    lateinit var shimmerUtils : ShimmerClass
    lateinit var recyclerDataAsociacion : GetDataClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_asociaciones)
        initShimmerUtils()
        initDataRecycler()
        getDataReciclerAsociaciones()
    }
    private fun initShimmerUtils(){
        shimmerUtils = ShimmerClass()
    }

    private fun initDataRecycler(){
        recyclerDataAsociacion = GetDataClass()
    }

    private fun getDataReciclerAsociaciones(){
        asociacionRV = findViewById(R.id.idRVCourses)
        asociacionRV.layoutManager = LinearLayoutManager(this)
        asociacionRV.setHasFixedSize(true)
        asociacionList = ArrayList()
        asociacionRVAdapter = RecyclerAdapterAsociacion(asociacionList, this)
        asociacionRV.adapter = asociacionRVAdapter

        Handler().postDelayed({
            val data = recyclerDataAsociacion.getAsociacionesData()
            asociacionList.addAll(data)
            shimmerUtils.stopLoadingAsociaciones(asociacionRVAdapter)
            asociacionRVAdapter.notifyDataSetChanged()

        },1500)

    }

    private fun goHome() {
        val intent = Intent(this, DesktopActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
