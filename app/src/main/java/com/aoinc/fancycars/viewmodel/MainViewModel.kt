package com.aoinc.fancycars.viewmodel

//import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.model.FancyCar
import com.aoinc.fancycars.network.ApiStub

class MainViewModel : ViewModel() {

    val carList = MutableLiveData<List<FancyCar>>()
    val carAvailabilityList = MutableLiveData<List<CarAvailability>>()

    suspend fun getCarList() {
        carList.postValue(ApiStub.getAllCars())
//        Log.d("TAG_X", "all cars got")
//        Log.d("TAG_X", "end of car list func")
    }

    suspend fun getCarAvailabilityList() {
       carAvailabilityList.postValue(ApiStub.getCarAvailabilityList())
    }
}