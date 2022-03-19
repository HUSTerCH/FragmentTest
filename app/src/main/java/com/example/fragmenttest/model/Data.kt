package com.example.fragmenttest.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Data {
    private val newsList = NewsList()
    private val newsLiveData = MutableLiveData(newsList)

    fun addUser() {

    }
    fun delete() {

    }
    fun getNews() : LiveData<NewsList> {
        return newsLiveData
    }
    companion object {
        private var INSTANCE:Data? = null
        fun getData():Data {
            return synchronized(Data::class) {
                val newInstance = INSTANCE ?: Data()
                INSTANCE = newInstance
                newInstance
            }
        }

    }

}