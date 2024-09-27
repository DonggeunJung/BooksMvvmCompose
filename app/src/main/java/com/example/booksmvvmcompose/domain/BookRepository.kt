package com.example.booksmvvmcompose.domain

import android.util.Log
import com.example.booksmvvmcompose.data.Book
import com.example.booksmvvmcompose.data.BookApi
import javax.inject.Inject

class BookRepository @Inject constructor(private var api: BookApi) {

    suspend fun reqBooks(): List<Book>? {
        return try {
            api.books()
        } catch (e: Exception) {
            Log.d("BookRepository", "${e.message}")
            null
        }
    }

}
