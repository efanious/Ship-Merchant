package com.example.shipmerchant.requests

import com.google.gson.annotations.SerializedName

data class QuoteRequest(
        @SerializedName("pickupRequested") val pickupRequested: Boolean,
        @SerializedName("plannedShipmentDateAndTime") val plannedShipmentDateAndTime: String,
        @SerializedName("packages") val packages: List<Package>,
        @SerializedName("receiverDetails") val receiverDetails: Details,
        @SerializedName("pickupDetails") val pickupDetails: Details
)


data class Package(
        val name: String,
        val weight: Long,
        val dimensions: Dimensions
)

data class Dimensions(
        val length: Long,
        val width: Long,
        val height: Long
)

data class Details(
        val cityName: String,
        val address: String
)

