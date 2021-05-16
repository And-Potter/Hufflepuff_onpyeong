package com.example.androidseminar.api

import com.example.androidseminar.data.request.RequestLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.example.androidseminar.data.reponse.ResponseLoginData

interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>
}