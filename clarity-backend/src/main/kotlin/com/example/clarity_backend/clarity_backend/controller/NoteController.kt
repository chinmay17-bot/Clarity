package com.example.clarity_backend.clarity_backend.controller

import com.example.clarity_backend.clarity_backend.database.model.Note
import com.example.clarity_backend.clarity_backend.database.repository.NoteRepository
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

//Mention this is a rest controller
@RestController
//Mention on what path to call this path controller
@RequestMapping("/notes")
class NoteController(
    private val repository: NoteRepository
) {
    //basic functions for a note
    //user level
    //1.save a note by user
    //2.delete a note by user
    //3.edit a note by user

    //construct data class to send request
    data class NoteRequest(
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
        //this is for testing purpose only, in real app we will get owner id from auth jwt token
        val ownerId: String?
    )

    //returned response from server
    data class NoteResponse(
        val id: String,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant
    )

    @PostMapping()
    fun save(
        @RequestBody
        body: NoteRequest
    ): NoteResponse {
        val note = repository.save(
            Note(
                //if an id is provided, that means user want to update the node so fetch it otherwise create a new one
                id = body.id?.let { ObjectId(it) } ?: ObjectId.get(),
                title = body.title,
                content = body.content,
                color = body.color,
                createdAt = Instant.now(),
                //NOT FINAL FUNCTIONALITY ONLY FOR TESTING PURPOSE
                ownerId = ObjectId() //dummy owner id
            )
        )

        return NoteResponse(
            id = note.id.toHexString(),
            title = note.title,
            content = note.content,
            color = note.color,
            createdAt = note.createdAt
        )
    }


    //NOTE THAT NOTERESPONSE CLASS IS USED MULTIPLE TIMES SO FIX IT AND REMOVE THIS CODE DUPLICATION
    @GetMapping
    fun findByOwnerId(
        @RequestParam(required = true) ownerId: String
    ): List<NoteResponse> {
        //fetched all notes by owner id and map to a List of response
        return repository.findAllByOwnerId(ObjectId(ownerId)).map {
            NoteResponse(
                id = it.id.toHexString(),
                title = it.title,
                content = it.content,
                color = it.color,
                createdAt = it.createdAt
            )
        }
    }
}