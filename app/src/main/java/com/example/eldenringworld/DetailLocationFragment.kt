package com.example.eldenringworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eldenringworld.databinding.FragmentDetailLocationBinding
import com.example.eldenringworld.model.locationData
import com.squareup.picasso.Picasso

class DetailLocationFragment : Fragment() {

    private var binding: FragmentDetailLocationBinding? = null
    private lateinit var localData: locationData

    //Data UI
    fun setLocalData(localData: locationData){
        this.localData = localData
        binding?.let { binding ->
            Picasso.get().load(localData.image).into(binding.imageView5)
        }
        binding?.locaName?.text = localData.name
        binding?.locaRegion?.text = localData.region
        binding?.locaDes?.text = localData.description
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailLocationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setLocalData(localData)
        super.onViewCreated(view, savedInstanceState)
    }
}