package com.guimpo.shopping.utilities

import com.guimpo.shopping.data.quote.FakeDatabase
import com.guimpo.shopping.data.quote.QuoteRepository
import com.guimpo.shopping.presentation.quotes.QuotesViewModelFactory

// Finally a singleton which doesn't need anything passed to the constructor
object InjectorUtils {

    // This will be called from QuotesActivity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}