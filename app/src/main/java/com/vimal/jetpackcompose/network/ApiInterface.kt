package com.vimal.jetpackcompose.network

import com.vimal.jetpackcompose.model.Quotes
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiInterface {

    @GET("quotes")
    suspend fun getUserData(): List<Quotes>
}