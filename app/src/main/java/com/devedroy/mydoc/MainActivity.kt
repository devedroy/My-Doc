package com.devedroy.mydoc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
 
// This is comment by bala
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
    }
}