package com.aoinc.fancycars.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.model.FancyCar

@Database(entities = arrayOf(FancyCar::class, CarAvailability::class), version = 1)
abstract class FancyCarDatabase : RoomDatabase() {
    abstract fun fancyCarDao(): FancyCarDAO

    companion object {
        const val DATABASE_NAME = "fancycars.db"
    }
}