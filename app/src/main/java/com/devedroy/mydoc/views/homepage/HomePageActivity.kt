package com.devedroy.mydoc.views.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devedroy.mydoc.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureHospitalAdapter()
        configureDepartmentsAdapter()
        configureTestsAdapter()
    }

    private fun configureDepartmentsAdapter() {
        TODO("Not yet implemented")
    }

    private fun configureTestsAdapter() {
        TODO("Not yet implemented")
    }

    private fun configureHospitalAdapter() {
        val myListData: List<DemoData>? = null //install data from ViewModel

        val mRecyclerDemoAdapter = RecyclerDemoAdapter(this, myListData)
        binding.rvHospitals.adapter = mRecyclerDemoAdapter
        binding.rvHospitals.layoutManager = LinearLayoutManager(this)
    }
}