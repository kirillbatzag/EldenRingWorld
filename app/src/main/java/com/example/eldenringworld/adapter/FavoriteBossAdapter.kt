package com.example.eldenringworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eldenringworld.databinding.ItemFavoriteBinding
import com.example.eldenringworld.model.FavoriteBossModel
import com.squareup.picasso.Picasso

class FavoriteBossAdapter(private val favoriteBossList: List<FavoriteBossModel>) : RecyclerView.Adapter<FavoriteBossAdapter.FavoriteBossViewHolder>() {

    inner class FavoriteBossViewHolder(private val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteBoss: FavoriteBossModel) {
            with(binding) {
                Picasso.get().load(favoriteBoss.image).into(photoFavorite)
                nameFavorite.text = favoriteBoss.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteBossViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteBossViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteBossViewHolder, position: Int) {
        val favoriteBoss = favoriteBossList[position]
        holder.bind(favoriteBoss)
    }

    override fun getItemCount(): Int {
        return favoriteBossList.size
    }
}