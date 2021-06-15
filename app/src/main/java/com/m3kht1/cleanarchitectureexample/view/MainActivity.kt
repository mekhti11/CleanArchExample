package com.m3kht1.cleanarchitectureexample.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.m3kht1.cleanarchitectureexample.R
import com.m3kht1.cleanarchitectureexample.viewmodel.CountriesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : CountriesViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)
        viewModel.refresh()

        swipeRefreshLayout.setOnRefreshListener {  }

        countriesRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countries ->
            countriesRV.visibility = View.VISIBLE
            countries?.let { countriesAdapter.updateCountries(it) }
        })

        viewModel.loadError.observe(this, Observer { isError ->
            isError?.let { errorTxt.visibility = if (it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isloading ->
            isloading?.let {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
                if (it){
                    errorTxt.visibility = View.INVISIBLE
                    countriesRV.visibility = View.INVISIBLE
                }
            }
        })
    }
}
