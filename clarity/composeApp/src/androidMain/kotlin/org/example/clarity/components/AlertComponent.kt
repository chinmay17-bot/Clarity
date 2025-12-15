package org.example.clarity.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.clarity.context.DialogState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertBox(
    state: DialogState,
    onDismissRequest: () -> Unit,
    onConfirmationRequest: () -> Unit, onCancelRequest: () -> Unit,
    noteId: String
) {
    val (title , message , confirmText ) = when(state){
        is DialogState.Delete -> Triple("Delete Note $noteId", "Are you sure you want to delete this note?", "Delete")
        is DialogState.Edit -> Triple("Edit Note $noteId", "Do you want to edit this note?", "Edit")
    }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(title) },
        text = { Text(message) },

        confirmButton = {
            TextButton(onClick = onConfirmationRequest) {
                Text(confirmText)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Cancel")
            }
        }
    )
}
