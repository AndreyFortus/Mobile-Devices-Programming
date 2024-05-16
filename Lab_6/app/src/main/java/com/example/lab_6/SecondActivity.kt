package com.example.lab_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_6.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonLeft.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.buttonRight.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString()
            val lastName = binding.editTextLastName.text.toString()

            val firstNameParcelable = binding.editTextFirstName.text.toString()
            val lastNameParcelable = binding.editTextFirstName.text.toString()
            val usernameData = Username(firstNameParcelable, lastNameParcelable)

            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("firstName", firstName)
                putExtra("lastName", lastName)
                putExtra("usernameData", usernameData)
            }

            startActivity(intent)
        }
    }
}
