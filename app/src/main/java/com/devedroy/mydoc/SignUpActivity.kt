package com.devedroy.mydoc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.devedroy.mydoc.databinding.SignUpBinding
import com.devedroy.mydoc.views.homepage.HomePageActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: SignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, HomePageActivity::class.java))
        }
    }
}