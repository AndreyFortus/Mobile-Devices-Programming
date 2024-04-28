package com.example.lab_5

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonTopLeft.setOnClickListener {
            binding.textView2.setText("You successful clicked on button!")
        }

        binding.buttonTopRight.setOnClickListener {
            binding.textView2.setTextColor(Color.RED)
        }

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.buttonTopLeft.setBackgroundColor(Color.GREEN)
                binding.buttonTopRight.setBackgroundColor(Color.GREEN)
            } else {
                binding.buttonTopLeft.setBackgroundColor(Color.CYAN)
                binding.buttonTopRight.setBackgroundColor(Color.CYAN)
            }
        }

        fun toastMsg(msg: String?) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        var textWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                toastMsg("Text not changed")
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                toastMsg("Text changing")

            }

            override fun afterTextChanged(s: Editable?) {
                toastMsg("Text changed")
            }

        }
        binding.editText.addTextChangedListener(textWatcher)
    }
}
