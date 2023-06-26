package com.example.gofit_10762.User

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RClientUser {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://backend10762.gofit10603.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(apiService::class.java)
}