package com.example.shoeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {

    private var _sList= MutableLiveData<ArrayList<Shoe>>()
    lateinit var shoeList:ArrayList<Shoe>
    var sList:LiveData<ArrayList<Shoe>> =_sList


    init {
addList()
//operator fun <Shoe> ArrayList<Shoe>.plus(element: Shoe) {
//    shoeList= ArrayList()
//
//    _sList.value = shoeList
//}
}



    fun addList(){
        shoeList= ArrayList()

        _sList.value = shoeList


    }


//private val _name= MutableLiveData<String>()
//     val name:LiveData<String>
//        get() =_name
//    private val _company= MutableLiveData<String>()
//    val company:LiveData<String>
//        get() =_company
//
//    private val _size= MutableLiveData<String>()
//    val size:LiveData<String>
//        get() =_size
//
//    private val _description= MutableLiveData<String>()
//    val description:LiveData<String>
//        get() =_description
//
//    fun addName(){
//        var namesList = mutableListOf<String>("name")
//        namesList.add(_name.toString())
//        Log.i("mynames", namesList.toString())
//    }
}


