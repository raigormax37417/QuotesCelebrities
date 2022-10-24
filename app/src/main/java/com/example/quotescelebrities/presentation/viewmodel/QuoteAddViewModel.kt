package com.example.quotescelebrities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.domain.usecase.SetQuoteUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteAddViewModel @Inject constructor(private val setQuoteUseCase: SetQuoteUseCase
): ViewModel() {

    fun addQuote(quote: QuoteModel) {
        viewModelScope.launch {
            setQuoteUseCase.setQuote(quote)
        }
    }
}