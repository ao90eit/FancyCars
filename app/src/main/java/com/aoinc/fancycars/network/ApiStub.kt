package com.aoinc.fancycars.network

import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.model.FancyCar

object ApiStub {

    private val carsList: MutableList<FancyCar> = mutableListOf()
    private val carAvailabilityList: MutableList<CarAvailability> = mutableListOf()

    suspend fun getAllCars(): List<FancyCar> {
        if (carsList.size == 0) {
            makeCars()
        }

        return carsList
    }

    suspend fun getCarAvailability(carId: Int): CarAvailability =
        carAvailabilityList.first { it.carId == carId }

    private fun makeCars() {
        carsList.add(
            FancyCar(1, "http://xxxxx", "car1", "make1",
        "model1", 2021)
        )
        carAvailabilityList.add(CarAvailability(1, "In Dealership"))


        carsList.add(
            FancyCar(2, "http://xxxxx", "car2", "make2",
            "model2", 2022)
        )
        carAvailabilityList.add(CarAvailability(2, "Out of Stock"))

        carsList.add(
            FancyCar(3, "http://xxxxx", "car3", "make3",
            "model3", 2023)
        )
        carAvailabilityList.add(CarAvailability(3, "Unavailable"))
    }
}