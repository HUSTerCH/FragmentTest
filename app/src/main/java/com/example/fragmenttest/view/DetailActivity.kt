package com.example.fragmenttest.view

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenttest.R
import kotlinx.android.synthetic.main.news_detail_page.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG,"onCreate OK")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_detail_page)
        val title = intent.getStringExtra("news_title").toString()
        val content = intent.getStringExtra("news_detail").toString()
        Log.e(TAG,title)
        Log.e(TAG,content)
        if (title != null && content != null) {
            val fragment = news_Detail as DetailPage
            fragment.refresh(title,content)
            Log.e(TAG,"Detail Page OK")
        } else {
            Log.e(TAG,"Detail Page not OK")
        }
    }

    companion object {
        fun actionStart(context: Context,title: String,content:String) {
            val intent = Intent(context,DetailActivity::class.java).apply {
                putExtra("news_detail",content)
                putExtra("news_title",title)
            }
            context.startActivity(intent)
            Log.e(TAG,"actionStart OK")
        }
    }
}