package com.example.eldenringworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eldenringworld.SecondFragment
import com.example.eldenringworld.databinding.ItemLocationsBinding
import com.example.eldenringworld.model.locationData
import com.squareup.picasso.Picasso

class LocationAdapter(private val listener: SecondFragment): RecyclerView.Adapter<LocationAdapter.LocalViewHolder>() {

    private var local: List<locationData> = listOf()
    private var filterLoca: List<locationData> = listOf()

    //filter fun
    fun filterData(query: String){
        filterLoca = if (query.isEmpty()){
            local
        } else{
            local.filter { local ->
                local.name.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    inner class LocalViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(loca: locationData){
            with(binding){
                Picasso.get().load(loca.image).into(imageView)
                itemName.text = loca.name
                idBoss.text = "id: ${loca.id}"

                itemView.setOnClickListener{
                    listener.onLocalItemClick(loca)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationAdapter.LocalViewHolder {
        val binding =
            ItemLocationsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocalViewHolder(binding)
    }


    override fun onBindViewHolder(holder: LocationAdapter.LocalViewHolder, position: Int) {
        if (position < filterLoca.size){
            val loca = filterLoca[position]
            holder.bind(loca)
        }
    }

    override fun getItemCount(): Int {
       return filterLoca.size
    }

    fun submitList(newList: List<locationData>) {
        local = newList
        filterData("")
    }



}