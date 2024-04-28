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

        val eventHandler = EventHandler()

        binding.buttonTopLeft.setOnClickListener {
            eventHandler.onButtonTopLeftClick()
        }

        binding.buttonTopRight.setOnClickListener {
            eventHandler.onButtonTopRightClick()
        }

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            eventHandler.onSwitchCheckedChanged(isChecked)
        }

        binding.editText.addTextChangedListener(eventHandler.textWatcher)
    }

    inner class EventHandler {
        val textWatcher = object : TextWatcher {
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

        fun onButtonTopLeftClick() {
            binding.textView2.text = "You successfully clicked on button!"
        }

        fun onButtonTopRightClick() {
            binding.textView2.setTextColor(Color.RED)
        }

        fun onSwitchCheckedChanged(isChecked: Boolean) {
            val color = if (isChecked) Color.GREEN else Color.CYAN
            binding.buttonTopLeft.setBackgroundColor(color)
            binding.buttonTopRight.setBackgroundColor(color)
            val state = if (isChecked) "ON" else "OFF"
        }
    }

    private fun toastMsg(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
