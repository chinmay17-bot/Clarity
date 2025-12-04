package org.example.clarity.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoteComponent(modifier: Modifier = Modifier, title: String, content: String,onEdit: () -> Unit, onDelete: () -> Unit) {
    // Implementation of the Note component goes here
    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text("Title: $title")
        Text("Content: $content")
        Row {
            IconButton(
                onClick = {
                    //edit note action
                    onEdit()
                }
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.Create,
                    contentDescription = "Edit",
                )
            }
            IconButton(
                onClick = {
                    //delete note action
                    onDelete()
                }
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.Delete,
                    contentDescription = "Delete",
                )
            }
        }

    }
}