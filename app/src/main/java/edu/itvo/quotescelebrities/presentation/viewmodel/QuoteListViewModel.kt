package edu.itvo.quotescelebrities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.quotescelebrities.data.model.QuoteResponse
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import edu.itvo.quotescelebrities.domain.usecase.GetQuoteRandomUseCase
import edu.itvo.quotescelebrities.domain.usecase.GetQuotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class QuoteListViewModel
@Inject constructor (private val getQuotesUseCase: GetQuotesUseCase
): ViewModel(){
    val quote = QuoteModel(0,"Solo se que no se nada","Socrates")
    private var _quotes = MutableStateFlow(QuoteResponse(false,"",listOf(
        quote)))
    val quotes : StateFlow<QuoteResponse> = _quotes

    private val _stateLoading = MutableStateFlow<Boolean>(false)
    val isLoading : StateFlow<Boolean> = _stateLoading

    fun  getQuotes() {
        _stateLoading.value =true
        viewModelScope.launch(Dispatchers.IO) {
            val quoteResponse = getQuotesUseCase.getQuotes().first()
            quoteResponse.let{
                _quotes.value =it!!
                _stateLoading.value =false
            }
        }
    }
}