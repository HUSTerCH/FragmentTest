package com.example.fragmenttest.view

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.fragmenttest.R
import com.example.fragmenttest.viewModel.MainViewModel
import com.example.fragmenttest.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}