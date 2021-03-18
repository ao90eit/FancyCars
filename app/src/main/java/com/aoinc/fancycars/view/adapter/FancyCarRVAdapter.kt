package com.aoinc.fancycars.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.aoinc.fancycars.R
import com.aoinc.fancycars.data.model.FancyCar
import com.aoinc.fancycars.view.adapter.FancyCarRVAdapter.CarViewHolder
import com.google.android.material.textview.MaterialTextView

class FancyCarRVAdapter(val carList: MutableList<FancyCar>)
    : RecyclerView.Adapter<CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder =
        CarViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.fancy_car_item, parent, false))

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]

        holder.apply {
//            carImage = car.imageUrl
            carText.text = "${car.name} ${car.make} ${car.model}"
            carYear.text = car.year.toString()


        }
    }

    override fun getItemCount(): Int = carList.size

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImage: ImageView = itemView.findViewById(R.id.car_image)
        val carText: MaterialTextView = itemView.findViewById(R.id.car_text)
        val carYear: MaterialTextView = itemView.findViewById(R.id.car_year)
        val carAvailabilty: MaterialTextView = itemView.findViewById(R.id.availability_text)
        val buyButton: Button = itemView.findViewById(R.id.buy_button)
    }
}