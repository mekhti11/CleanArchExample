package com.m3kht1.cleanarchitectureexample.services

import com.m3kht1.cleanarchitectureexample.di.DaggerApiComponent
import com.m3kht1.cleanarchitectureexample.model.CountriesAPI
import com.m3kht1.cleanarchitectureexample.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api : CountriesAPI

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries():Single<ArrayList<Country>> {
        return api.getCountries()
    }
}