package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.quotescelebrities.R
import com.example.quotescelebrities.databinding.ActivityQuoteRandomBinding
import com.example.quotescelebrities.databinding.FragmentCitasBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.presentation.viewmodel.QuoteAddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitasFragment : Fragment() {

    private var _binding : FragmentCitasBinding? = null;
    private val binding get() = _binding!!
    private val quoteAddViewModel: QuoteAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCitasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnSend.setOnClickListener {
            val quoteId = binding.tfid.text.toString().toInt()
            val quoteText = binding.tfquote.text.toString()
            val authorText = binding.tfauthor.text.toString()
            val quote = QuoteModel(quoteId, quoteText, authorText)

            saveQuote(quote)
        }

        return view
    }
    private fun saveQuote(quote: QuoteModel) {
        quoteAddViewModel.addQuote(quote)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}