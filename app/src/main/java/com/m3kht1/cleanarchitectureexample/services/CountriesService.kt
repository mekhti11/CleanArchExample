package com.m3kht1.cleanarchitectureexample.services

import com.m3kht1.cleanarchitectureexample.model.CountriesAPI
import com.m3kht1.cleanarchitectureexample.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {
    private val baseUrl = "https://raw.githubusercontent.com"
    private val api : CountriesAPI

    init {
        api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesAPI::class.java)
    }

    fun getCountries():Single<ArrayList<Country>> {
        return api.getCountries()
    }
}