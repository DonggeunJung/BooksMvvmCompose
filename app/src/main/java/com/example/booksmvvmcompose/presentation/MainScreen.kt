package com.example.booksmvvmcompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.booksmvvmcompose.R
import com.example.booksmvvmcompose.data.Book
import com.example.booksmvvmcompose.ui.theme.DarkBlue

@Composable
fun MainScreen(books: List<Book>, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(top = 30.dp, bottom = 50.dp, start = 0.dp, end = 0.dp)) {
        Header(modifier)
        BookList(books, modifier)
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth().height(50.dp), contentAlignment = Alignment.Center) {
        Text(text = stringResource(R.string.app_name), color = Color.DarkGray)
    }
}

@Composable
fun BookList(books: List<Book>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(books) {
            BookItem(it, modifier)
        }
    }
}

@Composable
fun BookItem(book: Book, modifier: Modifier = Modifier) {
    val imageSize = 80.dp; val fontSize = 12.sp
    Row(modifier = modifier.fillMaxWidth().height(imageSize)) {
        book.imageURL?.let {
            Image(painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = modifier.size(imageSize).padding(4.dp))
        }
        Column(modifier = modifier.fillMaxSize()) {
            Text(text = book.title, color = Color.DarkGray, fontSize = fontSize)
            book.author?.let {
                Text(text = it, color = DarkBlue, fontSize = fontSize)
            }
        }
    }
}
