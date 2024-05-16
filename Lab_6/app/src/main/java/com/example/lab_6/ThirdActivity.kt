package com.example.lab_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_6.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityThirdBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonLeft.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.buttonRight.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")

        binding.textViewFirstName.text = "Hi $firstName"
        binding.textViewLastName.text = lastName

        val usernameData = intent.getParcelableExtra<Username>("usernameData")
        usernameData?.let {
            binding.textViewUsername.text = "Hi ${usernameData.firstName} ${usernameData.lastName}"
        }


    }
}