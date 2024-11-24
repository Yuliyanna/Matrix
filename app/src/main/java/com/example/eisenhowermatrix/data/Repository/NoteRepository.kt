package com.example.eisenhowermatrix.data.Repository

import com.example.eisenhowermatrix.data.Api.NoteResponse
import com.example.eisenhowermatrix.data.Api.RemoteDataSource
import com.example.eisenhowermatrix.utils.BaseApiResponse
import com.example.eisenhowermatrix.utils.NetworkResult
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): BaseApiResponse() {
    suspend fun getAllNotes(token: String): NetworkResult<List<NoteResponse>> {
        return safeApiCall { remoteDataSource.getAllNotes(token = token) }
    }

    suspend fun getNotesById(token: String,id: String): NetworkResult<NoteResponse> {
        return safeApiCall { remoteDataSource.getNotesById(token = token, id = id) }

    }

    suspend fun postCreatNotes(token: String,id: String): NetworkResult<NoteResponse> {
        return safeApiCall { remoteDataSource.postCreatNotes(token = token,id = id) }

    }
    suspend fun putChangeNotes(token: String,id: String): NetworkResult<NoteResponse> {
        return safeApiCall { remoteDataSource.putChangeNotes(token = token, id = id) }

    }
    suspend fun deleteNotes(token: String,id: String): NetworkResult<NoteResponse> {
        return safeApiCall { remoteDataSource.deleteNotes(token = token, id = id) }

    }
}