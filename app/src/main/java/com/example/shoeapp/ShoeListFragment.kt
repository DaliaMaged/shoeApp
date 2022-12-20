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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.example.shoeapp.databinding.FragmentShoeListBinding
import kotlin.math.log

class ShoeListFragment : Fragment() {
lateinit var binding: FragmentShoeListBinding
 lateinit var shoeListViewModel: ShoeListViewModel
 lateinit var adpater: ShoeListAdpater
 lateinit var layout: LinearLayout
  lateinit var shoeList:ArrayList<Shoe>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list, container, false)


        shoeListViewModel=ViewModelProvider(this).get(ShoeListViewModel::class.java)

       var args=ShoeListFragmentArgs.fromBundle(requireArguments())

        binding.fabAdd.setOnClickListener {

            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        shoeListViewModel.sList.observe(viewLifecycleOwner, Observer { newList->

            newList.add(Shoe(args.name,args.company,args.size,args.description))

            adpater=ShoeListAdpater(newList)
            binding.shoeRecyclerView.adapter=adpater
        })


        binding.showListViewModel=shoeListViewModel
        binding.lifecycleOwner=this



        return binding.root
    }




//        var args=ShoeListFragmentArgs.fromBundle(requireArguments())
//       binding.Name.text=args.name
//
//
//        shoeListViewModel.name.observe(viewLifecycleOwner, Observer { newName ->
//           binding.Name.text=newName
//            shoeListViewModel.addName()
////            var textView=TextView(context)
////            textView.text=args.name
////            LinearLayout.LayoutParams(
////                LinearLayout.LayoutParams.MATCH_PARENT,
////                LinearLayout.LayoutParams.WRAP_CONTENT)
////                binding.myLinearLayout.addView(textView)
////            textView.text=newName
//
//        })
//        binding.Company.text=args.company
//        shoeListViewModel.company.observe(viewLifecycleOwner, Observer { newName ->
//            binding.Company.text=newName
//
//        })
//        binding.Size.text=args.size
//        shoeListViewModel.size.observe(viewLifecycleOwner, Observer { newName ->
//            binding.Size.text=newName
//        })
//        binding.Description.text=args.description
//        shoeListViewModel.description.observe(viewLifecycleOwner, Observer { newName ->
//            binding.Description.text=newName
//        })
//    shoeListViewModel.name.observe(viewLifecycleOwner, Observer { newName ->
//            binding.Name.text= newName.toString()
//
//        })

}