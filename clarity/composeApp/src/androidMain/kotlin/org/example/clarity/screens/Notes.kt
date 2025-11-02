package org.example.clarity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.clarity.components.NoteComponent
import org.example.clarity.utils.BackgroundColor

@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    val list = List(100) { "Item #$it" }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .background(BackgroundColor)
                .padding(vertical = 30.dp, horizontal = 16.dp)
        ) {
            Text(
                text = "Your Notes",
                fontSize = 14.sp
            )
        }

        Row(
            modifier = modifier.fillMaxSize()
        ) {
            // Sidebar
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.05f)
                    .fillMaxHeight()
                    .background(color = BackgroundColor)
            ) {}

            // Notes list
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(list.size) { index ->
                    NoteComponent(
                        title = "title $index",
                        content = "content $index"
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}
