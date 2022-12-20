package com.example.shoeapp

import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.shoeapp.databinding.ShoeItemBinding

class ShoeListAdpater (var shoeList:ArrayList<Shoe>?):
    Adapter<ShoeListAdpater.ShoeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeListViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.shoe_item,parent,false)
        return ShoeListViewHolder(view)

    }
    fun setData(shoes: ArrayList<Shoe>) {
        this.shoeList = shoes
        notifyDataSetChanged() //Refresh Data

    }


    override fun onBindViewHolder(holder: ShoeListViewHolder, position: Int) {
        val shoeItem= shoeList?.get(position)
        holder.name.text= shoeItem?.name.toString()
        holder.company.text=shoeItem?.company.toString()
        holder.description.text=shoeItem?.description.toString()
        holder.size.text=shoeItem?.size.toString()
    }

    override fun getItemCount(): Int {
        return shoeList?.size ?:0
    }

    class ShoeListViewHolder(itemView: View) : ViewHolder(itemView) {
        var name: TextView
        var company: TextView
        var size: TextView
        var description: TextView

        init {
            name=itemView.findViewById(R.id.Name)
            company=itemView.findViewById(R.id.Company)
            size=itemView.findViewById(R.id.Size)
            description=itemView.findViewById(R.id.Description)
        }



    }
}