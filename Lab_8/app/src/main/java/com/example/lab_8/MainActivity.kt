package com.example.lab_8

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val recyclerViewVertical = binding.recyclerViewVertical
        val recyclerViewHorizontal = binding.recyclerViewHorizontal

        recyclerViewVertical.layoutManager = LinearLayoutManager(this)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewHorizontal.layoutManager = layoutManager


        val dataV = ArrayList<ItemsViewModel>()
        val dataH = ArrayList<ItemsViewModel>()

        for (i in 1..15) {
            dataV.add(ItemsViewModel(R.drawable.lab8_image2, "item"+i))
            dataH.add(ItemsViewModel(R.drawable.lab8_image, "item"+i))
        }

        val adapter = CustomAdapter(dataV){position ->
            Toast.makeText(this, dataV[position].toString(), Toast.LENGTH_SHORT).show()
        }

        val horizontalAdapter = HorizontalAdapter(dataH){position ->
            Toast.makeText(this, dataH[position].toString(), Toast.LENGTH_SHORT).show()
        }

        recyclerViewVertical.adapter = adapter
        recyclerViewHorizontal.adapter = horizontalAdapter
    }
}