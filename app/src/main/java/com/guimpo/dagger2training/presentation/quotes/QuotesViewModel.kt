package com.guimpo.dagger2training.presentation.quotes

import android.arch.lifecycle.ViewModel
import com.guimpo.dagger2training.data.quote.Quote
import com.guimpo.dagger2training.data.quote.QuoteRepository

// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}