package com.example.eldenringworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eldenringworld.FirstFragment
import com.example.eldenringworld.databinding.ItemBossBinding
import com.example.eldenringworld.model.bossData
import com.squareup.picasso.Picasso


class BossAdapter(private val listener: FirstFragment) : RecyclerView.Adapter<BossAdapter.BossViewHolder>(){

    private var bosses: List<bossData> = listOf()
    private var filterBoses: List<bossData> = emptyList()

    //filter fun
    fun filterData(query: String) {
        filterBoses = if (query.isEmpty()) {
            bosses
        } else {
            bosses.filter { boss ->
                boss.name.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    inner class BossViewHolder(private val binding: ItemBossBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(boss: bossData){
            with(binding){
                Picasso.get().load(boss.image).into(imageView)
                itemName.text = boss.name
                idBoss.text = "id: ${boss.id}"

                itemView.setOnClickListener{
                    listener.onBossItemClick(boss)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BossAdapter.BossViewHolder {
        val binding =
            ItemBossBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BossViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BossAdapter.BossViewHolder, position: Int) {
        if (position < filterBoses.size) {
            val boss = filterBoses[position]
            holder.bind(boss)
        }
    }

    override fun getItemCount(): Int {
        return filterBoses.size
    }

    fun submitList(newList: List<bossData>) {
        bosses = newList
        filterData("")
    }
}

