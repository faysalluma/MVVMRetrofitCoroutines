package com.groupec.mvvmretrofitcoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// We use Factory to create an instance of ViewModels with arguments
class MyViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}