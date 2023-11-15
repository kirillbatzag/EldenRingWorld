package com.example.eldenringworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eldenringworld.adapter.BossAdapter
import com.example.eldenringworld.api.RetrofitHelper
import com.example.eldenringworld.api.apiBoss
import com.example.eldenringworld.databinding.FragmentFirstBinding
import com.example.eldenringworld.model.bossData
import com.example.eldenringworld.model.bossModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class FirstFragment : Fragment() {


    private lateinit var binding: FragmentFirstBinding
    private lateinit var bossAdapter: BossAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bossAdapter = BossAdapter(this)
        binding.RvBoss.layoutManager = LinearLayoutManager(requireContext())
        binding.RvBoss.adapter = bossAdapter


        //SearchView
        val searchView = binding.SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                bossAdapter.filterData(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                bossAdapter.filterData(newText.orEmpty())
                return true
            }
        })

        loadData()
    }

    fun onBossItemClick(bossData: bossData) {
        val detailBossFragment = DetailBossFragment()
        detailBossFragment.setBossData(bossData)
        val bossName = view?.findViewById<TextView>(R.id.name_boss)
        bossName?.text = bossData.name

        val args = Bundle()
        args.putParcelable("bossData", bossData)
        detailBossFragment.arguments = args

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, detailBossFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun loadData() {
        val service = RetrofitHelper.getInstance().create(apiBoss::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response: Response<bossModel> = service.getBosses()
                if (response.code() == 200 && response.isSuccessful) {
                    val bosses = response.body()?.data ?: emptyList()
                    withContext(Dispatchers.Main) {
                        bossAdapter.submitList(bosses)
                    }
                } else {
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}