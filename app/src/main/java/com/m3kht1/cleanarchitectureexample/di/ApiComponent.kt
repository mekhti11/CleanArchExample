package com.m3kht1.cleanarchitectureexample.di

import com.m3kht1.cleanarchitectureexample.services.CountriesService
import dagger.Component


@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)
}