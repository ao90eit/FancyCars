package com.aoinc.fancycars.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class CarAvailability(
    val carId: Int,
    val available: String
)

//GET /availability?id=123
//RESPONSE: {available: “In Dealership”}  // all  options are [ “Out of Stock”, “Unavailable”]