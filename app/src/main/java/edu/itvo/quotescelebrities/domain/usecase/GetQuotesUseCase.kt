package edu.itvo.quotescelebrities.domain.usecase

import edu.itvo.quotescelebrities.data.model.QuoteResponse
import edu.itvo.quotescelebrities.domain.QuoteRepository
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun getQuotes(): Flow<QuoteResponse?> = quoteRepository.getQuotes()

}