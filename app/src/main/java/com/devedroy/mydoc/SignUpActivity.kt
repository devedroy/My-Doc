package com.devedroy.mydoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devedroy.mydoc.databinding.SignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: SignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}