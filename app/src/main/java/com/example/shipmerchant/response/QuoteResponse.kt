package com.example.shipmerchant.response

import com.example.shipmerchant.requests.Details
import com.example.shipmerchant.requests.Dimensions
import com.example.shipmerchant.requests.Package
import com.google.gson.annotations.SerializedName

data class QuoteResponse(
        @SerializedName("status") val status: Boolean,
        @SerializedName("message") val message: String,
        @SerializedName("data") val data: Data
)


data class Data(
        val product_name: String,
        val product_code: String,
        val local_product_country_code: String,
        val total_price: Long,
        val pickup_capabilities : PickupCapabilities
)

data class PickupCapabilities(
        val pickup_earliest: String,
        val pickup_latest: String,
        val pickup_additional_days: Int,
        val pickup_day_of_week: Int
)
