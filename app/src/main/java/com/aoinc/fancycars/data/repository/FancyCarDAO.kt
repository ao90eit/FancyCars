package com.aoinc.fancycars.data.repository

import androidx.room.Dao
import androidx.room.Query
import com.aoinc.fancycars.data.model.FancyCar

@Dao
interface FancyCarDAO {

    @Query("SELECT * FROM fancycar")
    suspend fun getAllFancyCars(): List<FancyCar>
}