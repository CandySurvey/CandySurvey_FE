package com.flatwater.candysurvey.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object RetrofitInstance {

    val BASE_URL = "http://3.35.144.196:8080" // Server 주소 입력

    val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(MediaType.parse("application/json")!!))
        .build()

    fun getInstance() : Retrofit {
        return client
    }
}