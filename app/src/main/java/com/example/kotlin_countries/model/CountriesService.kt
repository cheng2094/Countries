package com.example.kotlin_countries.model


import com.example.kotlin_countries.di.DaggerApiComponent
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api: CountriesApi

    init{
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>>{
        return api.getCountries()
    }

}