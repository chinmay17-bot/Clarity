package org.example.clarity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.clarity.utils.BackgroundColor

@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    val list = List(100) { "Item #$it" }
    Column {
        Row {
            Text("Heading", modifier = Modifier.padding(16.dp).statusBarsPadding())
        }
        Row(
            modifier = modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
                    .background(color = BackgroundColor)
            ) {}
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(list.size) { index ->
                    Text(
                        text = list[index],
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }
    }


}