package com.example.shipmerchant.network

import com.example.shipmerchant.requests.QuoteRequest
import com.example.shipmerchant.response.QuoteResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


private const val BASE_URL = "https://staging-shopmax.herokuapp.com/api-docs/#/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MerchantApiService {
    @POST("shipments/quotes")
    fun getQuotes(@Body quoteRequest: QuoteRequest):
            Call<QuoteResponse>
}

object MerchantApi {
    val retrofitService : MerchantApiService by lazy {
        retrofit.create(MerchantApiService::class.java)
    }
}
