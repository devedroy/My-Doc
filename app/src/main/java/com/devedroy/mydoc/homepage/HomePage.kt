package com.devedroy.mydoc.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devedroy.mydoc.R
import com.devedroy.mydoc.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureHospitalAdapter()
    }

    private fun configureHospitalAdapter() {
        TODO("Not yet implemented")
    }
}