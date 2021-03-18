package com.aoinc.fancycars.data.repository

import android.content.Context
import androidx.room.Room

object CarRepository {

    fun getCarDatabase(context: Context): FancyCarDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            FancyCarDatabase::class.java,
            FancyCarDatabase.DATABASE_NAME
        ).build()
}