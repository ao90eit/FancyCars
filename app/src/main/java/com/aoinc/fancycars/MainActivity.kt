package com.aoinc.fancycars

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.aoinc.fancycars.view.adapter.FancyCarRVAdapter
import com.aoinc.fancycars.viewmodel.MainViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    private lateinit var carRecyclerView: RecyclerView
    private val fancyCarRVAdapter = FancyCarRVAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carRecyclerView = findViewById(R.id.cars_recycler_view)
        carRecyclerView.adapter = fancyCarRVAdapter

        mainViewModel.getCars()
        mainViewModel.carListData.observe(this, {
            fancyCarRVAdapter.updateList(it)
            sortCarsByAvailability()
        })
    }

    fun sortCarsByName() {
        fancyCarRVAdapter.sortByName()
    }

    fun sortCarsByAvailability() {
        fancyCarRVAdapter.sortByAvailability()
    }
}