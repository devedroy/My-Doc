package com.devedroy.mydoc.data.remote

import com.devedroy.mydoc.data.local.Hospital
import retrofit2.http.GET

const val BASE_URL = "https://hospitalapi.vercel.app/"

interface ApiService {
    @GET("/hospitals")
    fun getHospitalList(): retrofit2.Call<Hospital>
}