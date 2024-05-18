package com.example.lab_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.lab_7.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBlankBinding.inflate(layoutInflater)

        val firstName = arguments?.getString("firstName")
        val lastName = arguments?.getString("lastName")

        binding.textViewResult.text = "Hi $firstName $lastName!"

        // DO NOT DELETE THIS !
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var fullName:String? = ""

        childFragmentManager.setFragmentResultListener("name_data", this) {_, bundle->
            val fName = bundle.getString("firstName")
            val lName = bundle.getString("lastName")
            fullName = "$fName $lName"
        }

        binding.button.setOnClickListener {
            fullName?.let{
                findNavController().navigate(BlankFragmentDirections.actionBlankFragmentToFragment2())
            }
        }
    }
}