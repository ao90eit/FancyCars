package com.aoinc.fancycars.viewmodel

//import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aoinc.fancycars.data.model.CarAndAvailability
import com.aoinc.fancycars.data.repository.CarRepository

class MainViewModel : ViewModel() {

    private val carList = MutableLiveData<List<CarAndAvailability>>()
    val carListData: LiveData<List<CarAndAvailability>> = carList

    suspend fun getCars() {
        carList.postValue(CarRepository.getCarAndAvailability())
    }
}