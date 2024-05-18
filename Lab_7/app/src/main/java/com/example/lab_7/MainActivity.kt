package com.example.lab_7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import com.example.lab_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val fm:FragmentManager = supportFragmentManager
        val ft:FragmentTransaction = fm.beginTransaction()
        val fragment = BlankFragment()

        binding.buttonStart.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString()
            val lastName = binding.editTextTextLastName.text.toString()

            val bundle = Bundle().apply {
                putString("firstName", firstName)
                putString("lastName", lastName)
            }

            fragment.arguments = bundle
            ft.add(binding.frame1.id,fragment)

            ft.commit()

            val navHostFragment = binding.fragmentContainerView.getFragment<NavHostFragment>()

            val firstFragment = navHostFragment.childFragmentManager.fragments[0] as BlankFragment
            firstFragment.childFragmentManager.setFragmentResult(
                "name_data",
                bundleOf("firstName" to "Andrii",
                    "lastName" to "Fortus")
            )
        }

    }
}