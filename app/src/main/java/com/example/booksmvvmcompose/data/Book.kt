package com.example.booksmvvmcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class Book(var title: String, var author: String? = null, var imageURL: String? = null)