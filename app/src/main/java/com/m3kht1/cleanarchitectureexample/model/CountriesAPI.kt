package com.m3kht1.cleanarchitectureexample.model

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesAPI {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries():Single<ArrayList<Country>>
}