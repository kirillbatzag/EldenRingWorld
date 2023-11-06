package com.example.eldenringworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.eldenringworld.databinding.FragmentDetailBossBinding
import com.example.eldenringworld.model.bossData
import com.squareup.picasso.Picasso

class DetailBossFragment : Fragment() {
    private var binding: FragmentDetailBossBinding? = null
    private lateinit var bossData: bossData

    fun setBossData(bossData: bossData){
        //Data UI
        this.bossData = bossData
        binding?.let { binding ->
            Picasso.get().load(bossData.image).into(binding.imgBoss)
        }
        binding?.nameBoss?.text = bossData.name
        binding?.hpBoss?.text = "Healt Point: ${bossData.healthPoints}"
        if (bossData.healthPoints == null || bossData.healthPoints == "???") {
            binding?.hpBoss?.text = "Healt Point: Unkown"
        }
        binding?.regionBoss?.text = "Region: ${bossData.region}"
        binding?.locationBoss?.text = "Location: ${bossData.location}"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBossBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBossData(bossData)
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}





