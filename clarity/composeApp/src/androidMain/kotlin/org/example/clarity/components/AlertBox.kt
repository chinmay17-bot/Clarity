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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertBox(
    modifier: Modifier = Modifier, operation: String, onDismissRequest: () -> Unit,
    onConfirmationRequest: () -> Unit, onCancelRequest: () -> Unit
) {
    // Android-specific implementation of AlertBox
    if (operation == "delete") {
        // Android-specific UI for delete alert
        AlertDialog(
            onDismissRequest = {
                onDismissRequest()
            },
            confirmButton = {
                TextButton(onClick = {
                    //delete note request here
                    onConfirmationRequest()
                }) {
                    Text("Delete")
                }
            }, dismissButton = {
                TextButton(onClick = {
                    // cancel delete request here
                    onDismissRequest()
                }) {
                    Text("Cancel")
                }
            },
            icon = {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "Close")
            },
            text = {
                Text("Are you sure you want to delete this Note")
            },
            title = {
                Text("Alert Box")
            })
    } else if (operation == "edit") {
        // Android-specific UI for logout alert
        AlertDialog(
            onDismissRequest = {
                onDismissRequest()
            },
            confirmButton = {
                TextButton(onClick = {
                    //edit note request here
                    onConfirmationRequest()
                }) {
                    Text("Edit")
                }
            }, dismissButton = {
                TextButton(onClick = {
                    // cancel delete request here
                    onDismissRequest()
                }) {
                    Text("Cancel")
                }
            },
            icon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Close")
            },
            text = {
                Text("Edit note")
            },
            title = {
                Text("Edit Box")
            })
    }
}