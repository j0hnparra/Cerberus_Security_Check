package com.cerberus.securitycheck

import retrofit2.Call
import retrofit2.http.GET

interface BreachApi {

    @GET("breaches")
    fun getBreaches(): Call<List<Breaches>>


}