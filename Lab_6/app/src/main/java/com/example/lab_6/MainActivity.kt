package com.example.lab_6

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var countOfClicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonLeft.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.buttonRight.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.buttonClicks.setOnClickListener {
            countOfClicks++
            binding.textView3.text = countOfClicks.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("countOfClicks", countOfClicks)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countOfClicks = savedInstanceState.getInt("countOfClicks", 0)
        binding.textView3.text = countOfClicks.toString()
        Log.d ("Message", "Working")
    }

}