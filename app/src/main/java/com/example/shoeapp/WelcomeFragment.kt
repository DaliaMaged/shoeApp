package com.example.shoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoeapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
  lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        binding.button.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }

        return binding.root

    }

}