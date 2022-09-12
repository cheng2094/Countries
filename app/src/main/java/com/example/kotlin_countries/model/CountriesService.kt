package com.example.kotlin_countries.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {

    private val api: CountriesApi = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CountriesApi::class.java)

    fun getCountries(): Single<List<Country>>{
        return api.getCountries()
    }

    companion object {
        private const val BaseUrl: String = "https://raw.githubusercontent.com"
    }
}