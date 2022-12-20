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
  lateinit var shoeListViewModel: ShoeListViewModel
    lateinit var shoeList:ArrayList<Shoe>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        shoeListViewModel=ViewModelProvider(this).get(ShoeListViewModel::class.java)



        // Inflate the layout for this fragment
        binding.saveButton.setOnClickListener {
            var name=binding.editName.text.toString()
            var company=binding.companyEdit.text.toString()
            var size=binding.sizeEdit.text.toString()
            var description=binding.descEdit.text.toString()
          it.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(name,company, size, description))


            //addnew view
        }
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.showListViewModel=shoeListViewModel
        binding.lifecycleOwner=this

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController()) || super.onOptionsItemSelected(item)

    }

}