package com.example.eisenhowermatrix.domain


import com.example.eisenhowermatrix.data.Repository.PostRepository
import javax.inject.Inject

class DeletePostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(token: String,id: String) = postRepository.deletePosts(token = token, id = id)
}