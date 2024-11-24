package com.example.eisenhowermatrix.domain


import com.example.eisenhowermatrix.data.Api.NoteResponse
import com.example.eisenhowermatrix.data.Repository.NoteRepository
import javax.inject.Inject

class PostCreatNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository

){
    suspend fun invoke(token: String,id: String) = noteRepository.postCreatNotes(token = token,id = id)
}