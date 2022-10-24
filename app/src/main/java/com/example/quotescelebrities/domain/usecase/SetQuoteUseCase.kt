package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.domain.QuoteRepository
import com.example.quotescelebrities.domain.model.QuoteModel
import java.util.concurrent.Flow
import javax.inject.Inject

class SetQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun setQuote(quote: QuoteModel) = quoteRepository.setQuote(quote)
}