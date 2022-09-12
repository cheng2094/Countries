package com.example.kotlin_countries.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_countries.R
import com.example.kotlin_countries.model.Country
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter (var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>(){

    fun updateCountries(newCounties: List<Country>){
        countries.clear()
        countries.addAll(newCounties)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent,false)
    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val countryName = view.name

        fun bind(country:Country){
            countryName.text = country.countryName
        }
    }
}