package com.example.fragmenttest.view

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenttest.R
import kotlinx.android.synthetic.main.news_detail_page.*

class DetailActivity:AppCompatActivity() {
    companion object {
        fun actionStart(context: Context,title: String,content:String) {
            val intent = Intent(context,DetailActivity::class.java).apply {
                putExtra("news_title",title)
                putExtra("new_detail",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_detail)
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_detail")
        if (title != null && content != null) {
            val fragment = newsDetail as DetailPage
            fragment.refresh(title,content)
        }
    }
}