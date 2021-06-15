package com.m3kht1.cleanarchitectureexample.di

import com.m3kht1.cleanarchitectureexample.model.CountriesAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApiModule {

    private val baseUrl = "https://raw.githubusercontent.com"

    @Provides
    fun provideCountriesApi(): CountriesAPI{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesAPI::class.java)
    }
}