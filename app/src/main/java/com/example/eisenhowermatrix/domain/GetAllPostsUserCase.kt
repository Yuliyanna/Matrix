package com.example.eisenhowermatrix.domain


import com.example.eisenhowermatrix.data.Repository.PostRepository
import javax.inject.Inject

abstract class GetAllPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(token: String) = postRepository.getAllPosts(token = token)
}