package com.example.mvvmandlivedata.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmandlivedata.data.Retrofit
import com.example.mvvmandlivedata.models.Quote
import com.example.mvvmandlivedata.models.Quotes

class QuoteRepository(private val data: Retrofit) {

    private val quotes = MutableLiveData<Quote>()

    val quotesObj = LiveData<Quote>()
        get() = quotes
    fun getQuotes() {
        quotes.postValue(data.executeApi())
    }
}