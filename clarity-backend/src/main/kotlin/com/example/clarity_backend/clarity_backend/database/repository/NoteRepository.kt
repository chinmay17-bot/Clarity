package com.example.clarity_backend.clarity_backend.database.repository

import com.example.clarity_backend.clarity_backend.database.model.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository : MongoRepository<Note, ObjectId> {

}