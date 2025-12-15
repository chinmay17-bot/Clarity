package org.example.clarity.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.clarity.components.AlertBox
import org.example.clarity.components.NoteComponent
import org.example.clarity.context.DialogState

@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    val list = List(30) { "Item #$it" }

    var dialogState by remember { mutableStateOf<DialogState?>(null) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(65.dp),
                onClick = {
                    // navigate to InputScreen
                }) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = androidx.compose.material.icons.Icons.Default.Add,
                    contentDescription = "Add Note",
                    tint = MaterialTheme.colorScheme.surfaceBright,

                )
            }
        }) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = "Your Notes", fontSize = 25.sp
                )
            }

            // Notes list
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(list.size) { index ->
                    val note = list[index]
                    NoteComponent(title = "title $index", content = "content $index", onEdit = {
                        dialogState = DialogState.Edit(note)
                    }, onDelete = {
                        dialogState = DialogState.Delete(note)
                    })
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }

        // Dialog OUTSIDE layout
        dialogState?.let { state ->
            AlertBox(
                state = state,
                onDismissRequest = { dialogState = null },
                onConfirmationRequest = { dialogState = null },
                onCancelRequest = { dialogState = null },
                noteId = when (state) {
                    is DialogState.Delete -> state.noteId
                    is DialogState.Edit -> state.noteId
                }
            )
        }
    }
}

