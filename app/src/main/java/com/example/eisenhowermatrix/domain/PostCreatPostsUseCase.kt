package com.example.eisenhowermatrix.domain


import com.example.eisenhowermatrix.data.Api.PostResponse
import com.example.eisenhowermatrix.data.Repository.PostRepository
import javax.inject.Inject

class PostCreatPostsUseCase @Inject constructor(
    private val postRepository: PostRepository

){
    suspend fun invoke(token: String,body: PostResponse) = postRepository.postCreatPosts(token = token,body = body)
}