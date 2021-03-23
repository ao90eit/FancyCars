package com.aoinc.fancycars.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarAndAvailability(
    @PrimaryKey val primaryId: Int,
    @Embedded val fancyCar: FancyCar,
    @Embedded var availability: CarAvailability?
)
