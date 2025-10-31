package org.example.clarity.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NoteComponent(modifier: Modifier = Modifier, title: String, content: String) {
    // Implementation of the Note component goes here
    Text("Title: $title")
    Text("Content: $content")

}