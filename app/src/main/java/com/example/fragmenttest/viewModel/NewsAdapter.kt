package com.example.fragmenttest.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttest.R
import com.example.fragmenttest.model.News

class NewsAdapter(private val onClick:(News) -> Unit):
    ListAdapter<News,NewsAdapter.NewsViewHolder>(NewsDiffCallback) {
        class NewsViewHolder(itemView: View, val onClick: (News) -> Unit):
                RecyclerView.ViewHolder(itemView) {
            private val newsTitle:TextView = itemView.findViewById(R.id.news_title_view)
            private val newsContent:TextView = itemView.findViewById(R.id.news_content_view)
            private var currentNews:News ? = null
            init {
                itemView.setOnClickListener {
                    currentNews?.let {
                        onClick(it)
                    }
                }
            }
            fun bind(news: News) {
                currentNews = news
                newsTitle.text = news.newsTitle
                newsContent.text = news.newsContent
            }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(view,onClick)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }
}
object NewsDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return true
    }
}