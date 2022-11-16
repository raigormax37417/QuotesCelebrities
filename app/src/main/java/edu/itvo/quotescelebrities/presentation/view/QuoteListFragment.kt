package edu.itvo.quotescelebrities.presentation.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.quotescelebrities.core.utils.CellClickListener
import edu.itvo.quotescelebrities.databinding.FragmentQuoteListBinding
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import edu.itvo.quotescelebrities.presentation.viewmodel.QuoteListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class QuoteListFragment : Fragment(), CellClickListener {
    private lateinit var binding: FragmentQuoteListBinding
    private val quoteListViewModel: QuoteListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuoteListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        observer()

        lifecycleScope.launch (Dispatchers.IO) {
            quoteListViewModel.getQuotes()
        }
        return root
    }

    private fun callEditQuote(currentQuote: QuoteModel){
        val bundle = bundleOf(
            Pair("id", currentQuote.id),
            Pair("quote", currentQuote.quote),
            Pair("author",currentQuote.author)
        )


        val quoteEditFragment =QuoteEditFragment()
        quoteEditFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(edu.itvo.quotescelebrities.R.id.nav_host_fragment_content_drawer_navigation,
                quoteEditFragment).addToBackStack(this.tag)
            .setReorderingAllowed(true)
            .commit()

    }


    private fun observer(){

        lifecycleScope.launch {
            quoteListViewModel.quotes.collect{
                val adapter = QuoteAdapter( it.data as List<QuoteModel>, this@QuoteListFragment)
                with (binding){
                    recyclerView.layoutManager= LinearLayoutManager(context)
                    recyclerView.adapter = adapter
                }


            }
        }
        lifecycleScope.launch {
            quoteListViewModel.isLoading.collect {
                binding.loading.isVisible = it
            }
        }
    }


    override fun onCellClickListener(quoteModel: QuoteModel) {
        callEditQuote(quoteModel)
    }



}