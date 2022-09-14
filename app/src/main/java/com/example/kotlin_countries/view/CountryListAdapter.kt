package com.example.kotlin_countries.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_countries.databinding.ItemCountryBinding
import com.example.kotlin_countries.model.Country
import com.example.kotlin_countries.util.getProgressDrawable
import com.example.kotlin_countries.util.loadImage

class CountryListAdapter (var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountries(newCounties: List<Country>){
        countries.clear()
        countries.addAll(newCounties)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder{
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    class CountryViewHolder(val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root){

        private val progressDrawable = getProgressDrawable(itemView.context)

        fun bind(country:Country){
            binding.name.text = country.countryName
            binding.capital.text = country.capital
            binding.image.loadImage(country.flag, progressDrawable)
        }
    }
}