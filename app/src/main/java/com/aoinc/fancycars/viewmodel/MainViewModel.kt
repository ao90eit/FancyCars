package com.aoinc.fancycars.viewmodel

//import androidx.lifecycle.MutableLiveData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aoinc.fancycars.data.model.CarAndAvailability
import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.repository.CarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val carList = MutableLiveData<List<CarAndAvailability>>()
    val carListData: LiveData<List<CarAndAvailability>> = carList

    private val carAvailability = MutableLiveData<CarAvailability>()
    val carAvailabilityData: LiveData<CarAvailability> = carAvailability

    fun getCars() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                carList.postValue(CarRepository.getCarAndAvailability())
            }
        }
    }

    fun getAvailability(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val a = CarRepository.getCarAvail(id)
                Log.d("TAG_D", "emission - ${a.carId} ${a.available}")
                carAvailability.postValue(a)
            }
        }
    }
}