package edu.itvo.quotescelebrities.presentation.viewmodel


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.quotescelebrities.domain.usecase.GetQuoteRandomUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor (private val getQuoteRandomUseCase: GetQuoteRandomUseCase
): ViewModel()