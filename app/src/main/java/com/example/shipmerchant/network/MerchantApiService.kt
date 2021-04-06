package com.example.shipmerchant.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://staging-shopmax.herokuapp.com/api-docs/#/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MerchantApiService {
    @GET("shipments/quotes")
    fun getQuotes()
}