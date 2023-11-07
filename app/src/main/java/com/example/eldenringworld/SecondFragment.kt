package com.example.eldenringworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eldenringworld.adapter.LocationAdapter
import com.example.eldenringworld.api.RetrofitHelper
import com.example.eldenringworld.api.apiLocation
import com.example.eldenringworld.databinding.FragmentSecondBinding
import com.example.eldenringworld.model.locationData
import com.example.eldenringworld.model.locationModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class SecondFragment : Fragment() {


    private lateinit var binding: FragmentSecondBinding
    private lateinit var locationAdapter: LocationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationAdapter = LocationAdapter(this)
        binding.RvLoca.layoutManager = LinearLayoutManager(requireContext())
        binding.RvLoca.adapter = locationAdapter


        //SearchView
        val searchView = binding.SearchViewL
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextChange(query: String?): Boolean {
                locationAdapter.filterData(query.orEmpty())
                return false
            }

            override fun onQueryTextSubmit(newText: String?): Boolean {
                locationAdapter.filterData(newText.orEmpty())
                return true
            }
            })
        loadData()
    }

    fun onLocalItemClick(localData: locationData){
        val detailLocationFragment = DetailLocationFragment()
        detailLocationFragment.setLocalData(localData)
        val locaName = view?.findViewById<TextView>(R.id.loca_name)
        locaName?.text = localData.name

        val args = Bundle()
        args.putParcelable("locaData", localData)
        detailLocationFragment.arguments = args

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, detailLocationFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun loadData() {
        val service = RetrofitHelper.getInstance().create(apiLocation::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response: Response<locationModel> = service.getLocal()
                if (response.code() == 200 && response.isSuccessful) {
                    val local = response.body()?.data ?: emptyList()
                    withContext(Dispatchers.Main) {
                        locationAdapter.submitList(local)
                    }
                } else {
                    // Handle the error
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}