package com.m3kht1.cleanarchitectureexample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.m3kht1.cleanarchitectureexample.R
import com.m3kht1.cleanarchitectureexample.model.Country
import kotlinx.android.synthetic.main.country_item.view.*

class CountryListAdapter (private var countries:ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    fun updateCountries(data:ArrayList<Country>){
        countries.clear()
        countries.addAll(data)
        notifyDataSetChanged()
    }

    class CountryViewHolder(view: View):RecyclerView.ViewHolder(view){

        private var countryName = view.name

        fun bind(country:Country){
            countryName.text = country.countryName
            itemView.capital.text = country.capital
            Glide.with(itemView).load(country.flagPNG).into(itemView.flag_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.country_item , parent , false)
    )

    override fun getItemCount() =  countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }
}