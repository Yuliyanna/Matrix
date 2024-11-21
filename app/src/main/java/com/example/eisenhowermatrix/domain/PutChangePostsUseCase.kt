package com.example.eisenhowermatrix.domain


import com.example.eisenhowermatrix.data.Api.PostResponse
import com.example.eisenhowermatrix.data.Repository.PostRepository
import javax.inject.Inject

class PutChangePostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(token: String,id: String) = postRepository.putChangePosts(token = token, id = id)
}