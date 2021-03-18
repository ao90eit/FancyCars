package com.aoinc.fancycars.viewmodel

//import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aoinc.fancycars.data.model.CarAndAvailability
import com.aoinc.fancycars.data.repository.CarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val carList = MutableLiveData<List<CarAndAvailability>>()
    val carListData: LiveData<List<CarAndAvailability>> = carList

    fun getCars() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                carList.postValue(CarRepository.getCarAndAvailability())
            }
        }
    }
}