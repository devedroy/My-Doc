package com.devedroy.mydoc.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devedroy.mydoc.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureHospitalAdapter()
    }

    private fun configureHospitalAdapter() {
        val myListData: List<DemoData>? = null //install data from ViewModel

        val mRecyclerDemoAdapter: RecyclerDemoAdapter =
            RecyclerDemoAdapter(this, myListData)
        binding.rvHospitals.adapter = mRecyclerDemoAdapter
        binding.rvHospitals.layoutManager = LinearLayoutManager(this)
    }
}