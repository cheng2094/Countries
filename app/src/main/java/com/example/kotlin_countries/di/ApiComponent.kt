package com.example.kotlin_countries.di

import com.example.kotlin_countries.model.CountriesService
import com.example.kotlin_countries.viewmodel.ListViewModel
import dagger.Component

@Component(modules= [ApiModule::class])
interface ApiComponent {
    fun inject(service:CountriesService)

    fun inject(viewModel:ListViewModel)
}