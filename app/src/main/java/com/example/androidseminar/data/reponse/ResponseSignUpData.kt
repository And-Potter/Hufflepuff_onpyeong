package com.example.androidseminar.data.reponse

import com.google.gson.annotations.SerializedName

data class ResponseSignUpData(
    val success: Boolean,
    val message: String,
    val data: SignUpData?
)

data class SignUpData(
    val nickname: String
)
