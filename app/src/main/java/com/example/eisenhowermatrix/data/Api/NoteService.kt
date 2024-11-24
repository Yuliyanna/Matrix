package com.example.eisenhowermatrix.data.Api


import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface NoteService {
    @GET("auth/list")
    suspend fun getAllNotes(@Header("Authorization") token: String): retrofit2.Response<List<NoteResponse>>

    @GET("auth/list/{id}")
    suspend fun getNotesById(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Response<NoteResponse> //Call<List<Remember>>

    @POST("auth/list")
    suspend fun postCreatNotes(@Header("Authorization") token: String,@Path("id") id: String): retrofit2.Response<NoteResponse> //Call<List<Remember>>

    @PUT("auth/list/{id}")
    suspend fun putChangeNotes(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Response<NoteResponse>


    @DELETE("auth/list/{id}")
    suspend fun deleteNotes(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Response<NoteResponse>





}