package com.aoinc.fancycars.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aoinc.fancycars.data.model.CarAndAvailability

@Dao
interface FancyCarDAO {

    @Query("SELECT * FROM carandavailability")
    suspend fun getAllFancyCars(): List<CarAndAvailability>

    @Insert(entity = CarAndAvailability::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFancyCars(item: CarAndAvailability)
}