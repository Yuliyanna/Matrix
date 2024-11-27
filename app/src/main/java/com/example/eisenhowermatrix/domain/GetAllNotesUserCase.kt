package com.example.eisenhowermatrix.domain

import com.example.eisenhowermatrix.data.Repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(token: String) = noteRepository.getAllNotes(token = token)
}