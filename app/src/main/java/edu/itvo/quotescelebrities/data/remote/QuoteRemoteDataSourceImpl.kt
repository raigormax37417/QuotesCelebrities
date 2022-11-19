package edu.itvo.quotescelebrities.data.remote

import com.google.gson.Gson
import com.google.gson.JsonObject
import edu.itvo.quotescelebrities.data.model.QuoteResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuoteRemoteDataSourceImpl @Inject constructor(private  val api:ApiInterface):QuoteRemoteDataSource {
    override suspend fun getQuotes(): Flow<QuoteResponse> {
        val jsonObj: JsonObject =  api.getQuotes()
        val quoteResponse = Gson().fromJson(jsonObj, QuoteResponse::class.java)
        return flow{emit(quoteResponse)}
    }
}