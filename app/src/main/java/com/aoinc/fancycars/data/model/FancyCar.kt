package com.aoinc.fancycars.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FancyCar(
    @PrimaryKey val id: Int,
    val imageUrl: String,
    val name: String,
    val make: String,
    val model: String,
    val year: Int
)



//GET /availability?id=123
//RESPONSE: {available: “In Dealership”}  // all  options are [ “Out of Stock”, “Unavailable”]
//
//GET /cars
//RESPONSE:  [ {id: 1, img: http://myfancycar/image, name: “My Fancy Car”, make: “MyMake”, model: “MyModel”, year: 2018} ….]