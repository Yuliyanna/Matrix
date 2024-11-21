package com.example.eisenhowermatrix.data.Api

import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val postService: PostService) {

    suspend fun getAllPosts(token: String) = postService.getAllPosts(token = token)
    suspend fun getPostsById(token: String,id: String) = postService.getPostsById(token = token, id = id)
    suspend fun postCreatPosts(token: String,body: PostResponse) = postService.postCreatPosts(token = token,body = body)
    suspend fun putChangePosts(token: String,id: String) = postService.putChangePosts(token = token, id = id)
    suspend fun deletePosts(token: String,id: String) = postService.deletePosts(token = token, id = id)

}