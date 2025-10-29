package com.example.clarity_backend.clarity_backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

//Mention this is a rest controller
@RestController
//Mention on what path to call this path controller
@RequestMapping("/notes")
class NoteController {
    //basic functions for a note
    //user level
    //1.save a note by user
    //2.delete a note by user
    //3.edit a note by user

    //construct data class to send request
    data class NoteRequest(
        val id: String?,
        val title:String,
        val content:String,
        val color: Long,
    )

    //returned response from server
    data class NoteResponse(
        val id: String,
        val title:String,
        val content:String,
        val color: Long,
        val createdAt: Instant
    )

//    fun save(body : NoteRequest) : NoteResponse{
//
//    }
}