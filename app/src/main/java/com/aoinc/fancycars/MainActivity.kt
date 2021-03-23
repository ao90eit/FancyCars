package com.aoinc.fancycars

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ActionMenuView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.aoinc.fancycars.view.adapter.FancyCarRVAdapter
import com.aoinc.fancycars.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), FancyCarRVAdapter.OnVisibleDelegate {

    private val mainViewModel by viewModels<MainViewModel>()

    private lateinit var carRecyclerView: RecyclerView
    private val fancyCarRVAdapter = FancyCarRVAdapter(mutableListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carRecyclerView = findViewById(R.id.cars_recycler_view)
        carRecyclerView.adapter = fancyCarRVAdapter

        mainViewModel.getCars()
        mainViewModel.carListData.observe(this, {
            fancyCarRVAdapter.updateList(it)
        })

        mainViewModel.carAvailabilityData.observe(this, {
            Log.d("TAG_D", "in observe - ${it.carId}")
            fancyCarRVAdapter.updateItem(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return true
    }

    fun sortCarsByName() {
        fancyCarRVAdapter.sortByName()
    }

    fun sortCarsByAvailability() {
        fancyCarRVAdapter.sortByAvailability()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_name -> { sortCarsByName(); true }
            R.id.sort_availability -> { sortCarsByAvailability(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getAvailability(carId: Int) {
        mainViewModel.getAvailability(carId)
    }
}