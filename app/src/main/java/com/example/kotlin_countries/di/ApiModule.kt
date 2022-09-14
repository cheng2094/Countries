package com.example.kotlin_countries.di

import com.example.kotlin_countries.model.CountriesApi
import com.example.kotlin_countries.model.CountriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    fun provideCountriesApi(): CountriesApi {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }

    companion object {
        private const val BaseUrl: String = "https://raw.githubusercontent.com"
    }

    @Provides
    fun provideCountriesService(): CountriesService{
        return CountriesService()
    }
}