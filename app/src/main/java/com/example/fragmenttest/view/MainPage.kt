package com.example.fragmenttest.view
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
import com.example.fragmenttest.viewModel.MainViewModelFactory
import com.example.fragmenttest.viewModel.NewsAdapter

class MainPage:Fragment() {
    var isTwoPane = false
    private val mainViewModel by activityViewModels<MainViewModel> {
        MainViewModelFactory()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_page,container,false)
        val newsAdapter = NewsAdapter{news -> onClick(news) }
        val recyclerView : RecyclerView = view.findViewById(R.id.recycler_main)
        recyclerView.adapter = newsAdapter
        mainViewModel.newsData.observe(viewLifecycleOwner) {
            it?.let {
                newsAdapter.submitList(it as MutableList<News>)
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.detail_page) != null
    }
    fun onClick(news: News) {

    }
}
