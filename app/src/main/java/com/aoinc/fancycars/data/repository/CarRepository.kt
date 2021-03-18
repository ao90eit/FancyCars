package com.aoinc.fancycars.data.repository

import android.content.Context
import androidx.room.Room
import com.aoinc.fancycars.data.model.CarAndAvailability
import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.model.FancyCar
import com.aoinc.fancycars.network.ApiStub

object CarRepository {

    fun getCarDatabase(context: Context): FancyCarDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            FancyCarDatabase::class.java,
            FancyCarDatabase.DATABASE_NAME
        ).build()

    suspend fun getCarAndAvailability(): List<CarAndAvailability> {
        val carList = getCarList()
        val combinedList = mutableListOf<CarAndAvailability>()

        carList.map{
            val availability = getAvailability(it.fancyId)
            combinedList.add(CarAndAvailability(it.fancyId, it, availability))
        }

        return combinedList
    }

    private suspend fun getCarList(): List<FancyCar> = ApiStub.getAllCars()
    private suspend fun getAvailability(carId: Int): CarAvailability = ApiStub.getCarAvailability(carId)
}