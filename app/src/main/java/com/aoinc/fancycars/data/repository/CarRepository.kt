package com.aoinc.fancycars.data.repository

import com.aoinc.fancycars.CarApplication
import com.aoinc.fancycars.CheckNetworkAvailability
import com.aoinc.fancycars.data.model.CarAndAvailability
import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.model.FancyCar
import com.aoinc.fancycars.network.ApiStub

object CarRepository {

    suspend fun getCarAndAvailability(): List<CarAndAvailability> {
        //Check Network available
        var resultListCar = emptyList<CarAndAvailability>()
        resultListCar = if(CheckNetworkAvailability.networkIsAvailable()) {
            val carList = getCarList()
            carList.map {
                val availability = getAvailability(it.fancyId)
                //combinedList.add(CarAndAvailability(it.fancyId, it, availability))
                insertCarFromRemote(CarAndAvailability(it.fancyId, it, availability))
            }
            getCarCache()
        }else{
            getCarCache()
        }
        return resultListCar
    }

    private suspend fun getCarList(): List<FancyCar> = ApiStub.getAllCars()
    private suspend fun getAvailability(carId: Int): CarAvailability = ApiStub.getCarAvailability(carId)
    private suspend fun insertCarFromRemote(car: CarAndAvailability){
        CarApplication.dao.insertAllFancyCars(car)
    }
    private suspend fun getCarCache(): List<CarAndAvailability> =
        CarApplication.dao.getAllFancyCars()

}