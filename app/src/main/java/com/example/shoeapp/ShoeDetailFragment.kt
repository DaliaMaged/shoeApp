package com.example.shoeapp

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoeapp.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {
  lateinit var binding: FragmentShoeDetailBinding
  //lateinit var shoeListViewModel: ShoeListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        val shoeListViewModel=ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.showListViewModel=shoeListViewModel
        binding.lifecycleOwner=this

        // Inflate the layout for this fragment
        binding.saveButton.setOnClickListener {

          it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
           shoeListViewModel.setName(binding.editName.text.toString())
            shoeListViewModel.setCompany(binding.companyEdit.text.toString())
            shoeListViewModel.setSize(binding.sizeEdit.text.toString())
            shoeListViewModel.setDescription(binding.descEdit.text.toString())



            //addnew view
        }
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }


        return binding.root
    }


    }

