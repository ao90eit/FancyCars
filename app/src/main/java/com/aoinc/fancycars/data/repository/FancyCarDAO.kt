package com.aoinc.fancycars.data.repository

import androidx.room.Dao
import androidx.room.Query
import com.aoinc.fancycars.data.model.CarAndAvailability

@Dao
interface FancyCarDAO {

    @Query("SELECT * FROM carandavailability")
    suspend fun getAllFancyCars(): List<CarAndAvailability>
}