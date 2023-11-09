package com.example.eldenringworld.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel (

){
    init {
        Log.e("AAA", "VM create")
    }

    override fun onCleared() {
        Log.e("AAA", "VM create")
        super.onCleared()
    }

}