package com.example.quotescelebrities.domain

import com.example.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getQuoteRandom(): Flow<QuoteModel>
    suspend fun getQuote(quoteId: Int): Flow<QuoteModel>
    suspend fun setQuote(quote: QuoteModel)
}