package edu.itvo.quotescelebrities.domain

import edu.itvo.quotescelebrities.data.model.QuoteResponse
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getQuotes(): Flow<QuoteResponse?>
    suspend fun getQuoteRandom(): Flow<QuoteModel>
    suspend fun getQuote(quoteId:Int): Flow<QuoteModel>
    suspend fun editQuote(quoteModel: QuoteModel)
    suspend fun addQuote(quoteModel: QuoteModel)
}
