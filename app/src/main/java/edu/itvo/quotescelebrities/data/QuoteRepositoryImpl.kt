package edu.itvo.quotescelebrities.data

import edu.itvo.quotescelebrities.data.local.QuoteLocalDataSource
import edu.itvo.quotescelebrities.data.model.QuoteResponse
import edu.itvo.quotescelebrities.domain.QuoteRepository
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepositoryImpl @Inject constructor
    (private val localDataSource: QuoteLocalDataSource):
    QuoteRepository {

    override suspend fun getQuoteRandom(): Flow<QuoteModel> {
        return  localDataSource.getQuoteRandom()
    }

    override suspend fun getQuote(quoteId: Int): Flow<QuoteModel> {
        return localDataSource.getQuote(quoteId)
    }

    override suspend fun getQuotes(): Flow<QuoteResponse?> {
        return  localDataSource.getQuotes()
    }

    override suspend fun editQuote(quoteModel: QuoteModel) {
        return localDataSource.editQuote(quoteModel)
    }

    override suspend fun addQuote(quoteModel: QuoteModel) {
        return localDataSource.insert(quoteModel)
    }
}