package com.example.booksmvvmcompose.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

interface BookApi {
    @GET("books.json")
    suspend fun books() : List<Book>

    companion object {
        private const val BASE_URL = "http://de-coding-test.s3.amazonaws.com/"

        // Create Retrofit object
        val instance: BookApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json {
                isLenient = true
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build().create(BookApi::class.java)
    }
}