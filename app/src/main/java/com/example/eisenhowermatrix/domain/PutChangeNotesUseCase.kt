package com.example.eisenhowermatrix.domain


import com.example.eisenhowermatrix.data.Repository.NoteRepository
import javax.inject.Inject

class PutChangeNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(token: String,id: String) = noteRepository.putChangeNotes(token = token, id = id)
}