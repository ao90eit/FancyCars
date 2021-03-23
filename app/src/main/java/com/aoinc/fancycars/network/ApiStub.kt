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
            FancyCar(1, "https://tinyurl.com/5aryr3rz", "MATER", "Old",
        "Truck", 2021)
        )
        carAvailabilityList.add(CarAvailability(1, "In Dealership"))


        carsList.add(
            FancyCar(2, "https://tinyurl.com/df48zbr8", "SALLY", "Comfortable",
            "Sedan", 2022)
        )
        carAvailabilityList.add(CarAvailability(2, "Out of Stock"))

        carsList.add(
            FancyCar(3, "https://tinyurl.com/2kbd5c82", "LIGHTNING", "Fast",
            "Car", 2023)
        )
        carAvailabilityList.add(CarAvailability(3, "Unavailable"))

        carsList.add(
            FancyCar(4, "https://tinyurl.com/df48zbr8", "XXXXX", "Comfortable",
                "Sedan", 1667)
        )
        carAvailabilityList.add(CarAvailability(4, "In Dealership"))

        carsList.add(
            FancyCar(5, "https://tinyurl.com/5aryr3rz", "MATER", "Old",
                "Truck", 2021)
        )
        carAvailabilityList.add(CarAvailability(5, "In Dealership"))


        carsList.add(
            FancyCar(6, "https://tinyurl.com/df48zbr8", "SALLY", "Comfortable",
                "Sedan", 2022)
        )
        carAvailabilityList.add(CarAvailability(6, "Out of Stock"))

        carsList.add(
            FancyCar(7, "https://tinyurl.com/2kbd5c82", "LIGHTNING", "Fast",
                "Car", 2023)
        )
        carAvailabilityList.add(CarAvailability(7, "Unavailable"))

        carsList.add(
            FancyCar(8, "https://tinyurl.com/df48zbr8", "XXXXX", "Comfortable",
                "Sedan", 1667)
        )
        carAvailabilityList.add(CarAvailability(8, "In Dealership"))

        carsList.add(
            FancyCar(9, "https://tinyurl.com/2kbd5c82", "LIGHTNING", "Fast",
                "Car", 2023)
        )
        carAvailabilityList.add(CarAvailability(9, "Unavailable"))

        carsList.add(
            FancyCar(10, "https://tinyurl.com/df48zbr8", "XXXXX", "Comfortable",
                "Sedan", 1667)
        )
        carAvailabilityList.add(CarAvailability(10, "In Dealership"))
    }
}