package com.example.shoeapp

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {
    //name
     val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    var shoeListNames:ArrayList<String> = ArrayList()
    //company
    private val _company = MutableLiveData<String>("")
    val company: LiveData<String> = _company
    //size
    private val _size = MutableLiveData<String>("")
     val size: LiveData<String> = _size
    //description
    private val _description = MutableLiveData<String>("")
    val description: LiveData<String> = _description

    fun setName(name:String){
        _name.value=name
        saveNames(name)
    }
 fun setCompany(company:String){
     _company.value=company
 }
    fun setSize(size:String){
        _size.value=size
    }
    fun setDescription(description:String){
        _description.value=description
    }
    fun saveNames(name:String){
        shoeListNames.add(name)
        println(shoeListNames)
    }

}

