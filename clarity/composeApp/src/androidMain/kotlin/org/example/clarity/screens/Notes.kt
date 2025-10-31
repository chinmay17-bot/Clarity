package org.example.clarity.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    val list = List<String>(100) { "Item #$it" }
    LazyColumn (modifier = modifier) {
        items(count = list.size) { index ->
            Text("${list[index]} ")
        }
    }
}