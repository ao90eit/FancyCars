package com.aoinc.fancycars.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aoinc.fancycars.data.model.CarAndAvailability
import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.model.FancyCar

@Database(entities = arrayOf(CarAndAvailability::class), version = 1)
abstract class FancyCarDatabase : RoomDatabase() {
    abstract fun fancyCarDao(): FancyCarDAO

    companion object {
        const val DATABASE_NAME = "fancycars.db"
        @Volatile
        var INSTANCE: FancyCarDatabase? = null

        fun newInstance(context: Context): FancyCarDatabase {
            return INSTANCE ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context,
                    FancyCarDatabase::class.java,
                    DATABASE_NAME
                )
                    .build()
                INSTANCE = db
                db
            }
        }
    }
}