package edu.itvo.quotescelebrities.data.remote

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.POST

interface QuoteApiInterface {
    @GET("api/v1/quotes")
    suspend fun getQuotes(): JsonObject

    @POST("api/v1/quotes")
    suspend fun addQuotes(): JsonObject
}