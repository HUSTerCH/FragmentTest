package com.example.fragmenttest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmenttest.R
import kotlinx.android.synthetic.main.news_detail.*

class DetailPage:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_detail,container,false)
    }
    fun refresh(title:String,content:String) {
        detail_page_frag.visibility = View.VISIBLE
        news_content.text = title
        news_title.text = content
    }
}