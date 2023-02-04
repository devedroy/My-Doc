package com.devedroy.mydoc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//comment by dev

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
    }
}
