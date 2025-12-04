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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.clarity.components.NoteComponent
import org.example.clarity.utils.BackgroundColor
import org.example.clarity.components.AlertBox
@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    val list = List(100) { "Item #$it" }

    //alert box content
    var dialogState by remember { mutableStateOf<DialogState?>(null) }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
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
            ) {}

            // Notes list
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(list.size) { index ->
                    val note= list[index]
                    NoteComponent(
                        title = "title $index",
                        content = "content $index",
                        //dialog state trigger for testing
                        onEdit = {
                            dialogState = DialogState.Edit(note)
                        },
                        onDelete = {
                            dialogState = DialogState.Delete(note)
                        }
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            dialogState?.let{
                state ->
                AlertBox(
                    state = state,
                    onDismissRequest = { dialogState = null },
                    onConfirmationRequest = { dialogState = null },
                    onCancelRequest = { dialogState = null },
                    noteId = when(state){
                        is DialogState.Delete -> state.noteId
                        is DialogState.Edit -> state.noteId
                    }
                ) 
            }
        }
    }
}
