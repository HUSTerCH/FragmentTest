package com.example.fragmenttest.view

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttest.R
import com.example.fragmenttest.model.News
import com.example.fragmenttest.viewModel.MainViewModel
import com.example.fragmenttest.viewModel.NewsAdapter
import kotlinx.android.synthetic.main.main_page.*

class MainPage:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_page,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsAdapter = NewsAdapter{news -> onClick(news) }
//        val recyclerView : RecyclerView = view.findViewById(R.id.recycler_main)
//        recyclerView.adapter = newsAdapter
        recycler_main.adapter = newsAdapter
    }

    fun onClick(news: News) {

    }
}
