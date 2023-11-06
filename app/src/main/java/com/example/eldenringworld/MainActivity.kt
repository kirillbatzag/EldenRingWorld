package com.example.eldenringworld


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eldenringworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(FirstFragment())

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