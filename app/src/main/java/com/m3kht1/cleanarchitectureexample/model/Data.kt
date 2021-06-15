package com.m3kht1.cleanarchitectureexample.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    var countryName: String?,
    @SerializedName("capital")
    var capital : String?,
    @SerializedName("flagPNG")
    var flagPNG : String?)