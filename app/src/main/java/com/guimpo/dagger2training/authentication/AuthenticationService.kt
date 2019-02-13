package com.guimpo.dagger2training.authentication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {
    @POST("auth/login")
    fun getToken(@Body auth: Auth): Call<Auth>
}
