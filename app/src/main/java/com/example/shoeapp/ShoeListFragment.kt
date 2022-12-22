package com.example.shoeapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
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
import androidx.navigation.ui.NavigationUI

class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
   // lateinit var shoeListViewModel: ShoeListViewModel
    lateinit var shoeListNames:ArrayList<String>
    lateinit var textView:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)


        val shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.showListViewModel = shoeListViewModel
        binding.lifecycleOwner = this
        shoeListNames=ArrayList()

        shoeListViewModel.name.observe(viewLifecycleOwner, Observer { newName->
           // binding.nameText.text=newName
           // shoeListViewModel.saveNames(newName)
            addView("Name: $newName")

            if (savedInstanceState != null){
                textView.text
            }
        })
        shoeListViewModel.company.observe(viewLifecycleOwner, Observer { newCompany->
           // binding.companyText.text=newCompany
            addView("Company: $newCompany")

        })
        shoeListViewModel.size.observe(viewLifecycleOwner, Observer { newSize->
           // binding.sizeText.text=newSize
            addView("Size $newSize")

        })
        shoeListViewModel.description.observe(viewLifecycleOwner, Observer { newDescription->
            //binding.descText.text=newDescription
            addView("Description $newDescription")

        })



        binding.fabAdd.setOnClickListener {

            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }






        return binding.root
    }
fun addView(text:String){
    textView=TextView(context)
    textView.text=text
    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
    )
    textView.layoutParams = params
    textView.textSize = 24F
    textView.setTextColor(Color.parseColor("#d69f7e"))
    binding.linearLayout.addView(textView)
}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
       textView.text
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return  NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}




