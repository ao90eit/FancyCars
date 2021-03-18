package com.aoinc.fancycars

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aoinc.fancycars.viewmodel.MainViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainScope().launch {
            withContext(Dispatchers.IO) {
//                delay(1000)
                mainViewModel.getCarList()
                mainViewModel.getCarAvailabilityList()
            }

//            Log.d("TAG_X", "in launch")
        }

//        Log.d("TAG_X", "after launch")

        mainViewModel.carAvailabilityList.observe(this, {
            Log.d("TAG_X", "${it[1]}")
        })
    }
}