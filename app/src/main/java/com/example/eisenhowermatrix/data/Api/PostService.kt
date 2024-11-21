package com.example.eisenhowermatrix.data.Api


import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostService {
    @GET("auth/list")
    suspend fun getAllPosts(@Header("Authorization") token: String): retrofit2.Response<List<PostResponse>>

    @GET("auth/list/{id}")
    suspend fun getPostsById(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Response<PostResponse> //Call<List<Remember>>

    @POST("auth/list")
    suspend fun postCreatPosts(@Header("Authorization") token: String,@Body body: PostResponse): retrofit2.Response<PostResponse> //Call<List<Remember>>

    @PUT("auth/list/{id}")
    suspend fun putChangePosts(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Response<PostResponse>


    @DELETE("auth/list/{id}")
    suspend fun deletePosts(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Response<PostResponse>





}