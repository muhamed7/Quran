package com.example.quraan.ApiManager
import com.example.quraan.ApiManager.Model.RadioResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {

    @GET("radios/radio_arabic.json")
    fun getRadioChannels():Call<RadioResponse>
}