package com.example.fragmenttest.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragmenttest.model.Data
import java.lang.IllegalArgumentException

class MainViewModel(val data: Data) : ViewModel() {
    val newsData = data.getNews()
}

class MainViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(data = Data.getData()) as T
        }
        throw IllegalArgumentException("Unknown")
    }
}