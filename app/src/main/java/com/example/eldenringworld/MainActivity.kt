package com.example.eldenringworld


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.eldenringworld.databinding.ActivityMainBinding
import com.example.eldenringworld.mvvm.MainViewModel

class MainActivity : AppCompatActivity() {
    //vm - this is ViewModel
    private lateinit var vm: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //testMVVM
        Log.e("AAA", "Activity crated")
        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        //Start Fragment
        replaceFragment(FirstFragment())

        //Select Fragment
        binding.bNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.boss -> replaceFragment(FirstFragment())
                R.id.loca -> replaceFragment(SecondFragment())
                else ->{
                }
            }
            true
        }
    }

    //Navigation for bottom menu
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransient = fragmentManager.beginTransaction()
        fragmentTransient.replace(R.id.fragmentContainerView,fragment)
        fragmentTransient.commit()
    }
}