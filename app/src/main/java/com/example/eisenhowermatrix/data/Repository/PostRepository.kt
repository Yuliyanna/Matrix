package com.example.eisenhowermatrix.data.Repository

import com.example.eisenhowermatrix.data.Api.PostResponse
import com.example.eisenhowermatrix.data.Api.RemoteDataSource
import com.example.eisenhowermatrix.utils.BaseApiResponse
import com.example.eisenhowermatrix.utils.NetworkResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): BaseApiResponse() {
    suspend fun getAllPosts(token: String): NetworkResult<List<PostResponse>> {
        return safeApiCall { remoteDataSource.getAllPosts(token = token) }
    }

    suspend fun getPostsById(token: String,id: String): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.getPostsById(token = token, id = id) }

    }

    suspend fun postCreatPosts(token: String,body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.postCreatPosts(token = token,body = body) }

    }
    suspend fun putChangePosts(token: String,id: String): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.putChangePosts(token = token, id = id) }

    }
    suspend fun deletePosts(token: String,id: String): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.deletePosts(token = token, id = id) }

    }
}