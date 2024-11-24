package com.example.eisenhowermatrix.data.Api

import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val noteService: NoteService) {

    suspend fun getAllNotes(token: String) = noteService.getAllNotes(token = token)
    suspend fun getNotesById(token: String,id: String) = noteService.getNotesById(token = token, id = id)
    suspend fun postCreatNotes(token: String,id: String) = noteService.postCreatNotes(token = token,id = id)
    suspend fun putChangeNotes(token: String,id: String) = noteService.putChangeNotes(token = token, id = id)
    suspend fun deleteNotes(token: String,id: String) = noteService.deleteNotes(token = token, id = id)

}