package com.example.booksmvvmcompose.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksmvvmcompose.data.Book
import com.example.booksmvvmcompose.domain.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookViewModel @Inject constructor(private var bookRepository: BookRepository) : ViewModel() {
    private val _books = mutableStateListOf<Book>()
    val books: List<Book> = _books

    // Request Book data list to Repository
    fun reqBooks() {
        viewModelScope.launch {
            val res = bookRepository.reqBooks()

            withContext(Dispatchers.Main) {
                res?.let { _books.addAll(it) }
            }
        }
    }

}
