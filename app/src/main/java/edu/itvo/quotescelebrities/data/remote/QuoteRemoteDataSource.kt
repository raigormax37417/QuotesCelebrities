package edu.itvo.quotescelebrities.data.remote

import edu.itvo.quotescelebrities.data.model.QuoteResponse
import kotlinx.coroutines.flow.Flow


interface QuoteRemoteDataSource {
    suspend fun getQuotes(): Flow<QuoteResponse>
}