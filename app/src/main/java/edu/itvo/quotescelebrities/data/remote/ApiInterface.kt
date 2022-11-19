package edu.itvo.quotescelebrities.data.remote

import com.google.gson.JsonObject
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/v1/quotes")
    suspend fun getQuotes(): JsonObject
}