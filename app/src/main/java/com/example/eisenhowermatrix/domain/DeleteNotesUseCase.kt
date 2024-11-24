package com.example.eisenhowermatrix.domain


import com.example.eisenhowermatrix.data.Repository.NoteRepository
import javax.inject.Inject

class DeleteNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(token: String,id: String) = noteRepository.deleteNotes(token = token, id = id)
}