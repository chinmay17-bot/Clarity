package org.example.clarity.screens

sealed class DialogState{
    data class Edit(val noteId: String): DialogState()
    data class Delete(val noteId: String): DialogState()
}