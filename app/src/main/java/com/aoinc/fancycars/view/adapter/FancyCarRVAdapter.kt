package com.aoinc.fancycars.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.aoinc.fancycars.R
import com.aoinc.fancycars.data.model.CarAndAvailability
import com.aoinc.fancycars.data.model.CarAvailability
import com.aoinc.fancycars.data.model.FancyCar
import com.aoinc.fancycars.view.adapter.FancyCarRVAdapter.CarViewHolder
import com.bumptech.glide.Glide
import com.google.android.material.textview.MaterialTextView

class FancyCarRVAdapter(
    private var carList: List<CarAndAvailability>,
    private var onVisibleDelegate: OnVisibleDelegate
)
    : RecyclerView.Adapter<CarViewHolder>() {

    fun updateList(newList: List<CarAndAvailability>) {
        carList = newList
        notifyDataSetChanged()
    }

    fun updateItem(avail: CarAvailability) {
        Log.d("TAG_D", "in update - ${avail.carId}")
        val index = carList.indexOfFirst { it.primaryId == avail.carId }
        carList[index].availability = avail
        notifyItemChanged(index)
    }

    interface OnVisibleDelegate {
        fun getAvailability(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder =
        CarViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.fancy_car_item, parent, false))

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]

        // fix load before view
        car.availability?.let {} ?: {
            onVisibleDelegate.getAvailability(car.primaryId)
            Log.d("TAG_X", "getting availability for car #${car.primaryId}")
        }()

        holder.apply {

            Glide.with(itemView.context)
                .load(car.fancyCar.imageUrl)
                .placeholder(R.drawable.ic_android_black_24dp)
                .into(carImage)

            Log.d("TAG_X", car.fancyCar.imageUrl)

            carText.text = "${car.fancyCar.name} ${car.fancyCar.make} ${car.fancyCar.model}"
            carYear.text = car.fancyCar.year.toString()

            car.availability?.let {
                when (it.available) {
                    "In Dealership" -> {
                        buyButton.visibility = View.VISIBLE
                        carAvailabilty.visibility = View.INVISIBLE
                    }
                    else -> {
                        buyButton.visibility = View.INVISIBLE
                        carAvailabilty.visibility = View.VISIBLE
                        carAvailabilty.text = it.available
                    }
                }
            } ?: {
                buyButton.visibility = View.INVISIBLE
                carAvailabilty.visibility = View.VISIBLE
                carAvailabilty.text = "loading"
            }()

        }
    }

    override fun getItemCount(): Int = carList.size

    fun sortByName() {
        carList = carList.sortedBy { it.fancyCar.name }
        notifyDataSetChanged()
    }

    fun sortByAvailability() {
        carList = carList.sortedBy { it.availability?.available != "In Dealership" }
        notifyDataSetChanged()
    }

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImage: ImageView = itemView.findViewById(R.id.car_image)
        val carText: MaterialTextView = itemView.findViewById(R.id.car_text)
        val carYear: MaterialTextView = itemView.findViewById(R.id.car_year)
        val carAvailabilty: MaterialTextView = itemView.findViewById(R.id.availability_text)
        val buyButton: Button = itemView.findViewById(R.id.buy_button)
    }
}