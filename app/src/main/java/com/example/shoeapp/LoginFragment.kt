package com.example.shoeapp

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoeapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        binding.welcome.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.signIn.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_shoeDetailFragment)

        }

        return binding.root


    }

}