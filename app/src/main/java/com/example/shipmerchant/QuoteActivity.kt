package com.example.shipmerchant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.shipmerchant.network.MerchantApi
import com.example.shipmerchant.network.MerchantApiService
import com.example.shipmerchant.requests.Details
import com.example.shipmerchant.requests.Dimensions
import com.example.shipmerchant.requests.Package
import com.example.shipmerchant.requests.QuoteRequest
import com.example.shipmerchant.response.QuoteResponse
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        val quoteButton = findViewById(R.id.getQuoteButton) as Button
        quoteButton.setOnClickListener {
            getQuote()
        }
    }

    private fun getQuote() {

        //Test qote
        val dim = Dimensions(
            length = 40,
            width = 30,
            height = 20
        )

        val pack = Package(
            name = "Shoe",
            weight = 60,
            dimensions = dim
        )

        val details = Details(
            cityName = "Lagos",
            address = "Yaba"
        )

        val pickupDetails = Details(
            cityName = "Lagos",
            address = "Yaba"
        )

        data class Details(
            val cityName: String,
            val address: String
        )

        val list: MutableList<Package> = mutableListOf(pack)

        val quoteRequest = QuoteRequest(
            pickupRequested = true,
            plannedShipmentDateAndTime = "23-02-21",
            packages = list,
            receiverDetails = details,
            pickupDetails = pickupDetails
        )

        MerchantApi.retrofitService.getQuotes(quoteRequest).enqueue(object: Callback<QuoteResponse> {
            override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                Toast.makeText(this@QuoteActivity, "Failure: ${t.message}.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<QuoteResponse>, response: Response<QuoteResponse>) {
                Toast.makeText(this@QuoteActivity, "Success : ${response.body()?.message}."
                        + "\n ${response.body()?.status.toString()}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}