package com.example.eldenringworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eldenringworld.adapter.FavoriteBossAdapter
import com.example.eldenringworld.databinding.FragmentFavoriteBinding
import com.example.eldenringworld.model.FavoriteBossModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    //Сделать и настроить фрагмент для FavoriteBoss

}