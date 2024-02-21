package com.samsung.activitylearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("returned_data", "Hi, MainActivity!")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}