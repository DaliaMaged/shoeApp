package com.example.shoeapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.example.shoeapp.databinding.FragmentShoeListBinding
import kotlin.math.log
import androidx.fragment.app.activityViewModels

class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
   // lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)


        val shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.showListViewModel = shoeListViewModel
        binding.lifecycleOwner = this

        shoeListViewModel.name.observe(viewLifecycleOwner, Observer { newName->
            binding.nameText.text=newName
           println("doda $newName")
        })
        shoeListViewModel.company.observe(viewLifecycleOwner, Observer { newCompany->
            binding.companyText.text=newCompany

        })
        shoeListViewModel.size.observe(viewLifecycleOwner, Observer { newSize->
            binding.sizeText.text=newSize

        })
        shoeListViewModel.description.observe(viewLifecycleOwner, Observer { newDescription->
            binding.descText.text=newDescription

        })



        binding.fabAdd.setOnClickListener {

            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }






        return binding.root
    }

}


