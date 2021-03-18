package com.aoinc.fancycars

import android.app.Application
import com.aoinc.fancycars.data.repository.FancyCarDAO
import com.aoinc.fancycars.data.repository.FancyCarDatabase

class CarApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        dao=
            FancyCarDatabase.newInstance(this.applicationContext).fancyCarDao()
    }
    companion object{
        lateinit var dao: FancyCarDAO
            private set
    }
}