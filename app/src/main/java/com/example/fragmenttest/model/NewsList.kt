package com.example.fragmenttest.model

class NewsList {
    fun newsList() :List<News> {
        return listOf(
            News(
                newsTitle = "title1",
                newsContent = "news1news1news1news1news1news1news1news1news1news1news1",
                newsSort = 1
            ),
        )

    }
}