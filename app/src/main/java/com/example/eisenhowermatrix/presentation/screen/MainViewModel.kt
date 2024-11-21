package com.example.eisenhowermatrix.presentation.screen


import android.preference.PreferenceScreen
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eisenhowermatrix.data.Api.PostResponse
import com.example.eisenhowermatrix.domain.DeletePostsUseCase
import com.example.eisenhowermatrix.domain.GetAllPostUseCase
import com.example.eisenhowermatrix.domain.GetPostsByIdUseCase
import com.example.eisenhowermatrix.domain.PostCreatPostsUseCase
import com.example.eisenhowermatrix.domain.PutChangePostsUseCase
import com.example.eisenhowermatrix.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val deletePostsUseCase: DeletePostsUseCase,
    private val getAllPostUseCase: GetAllPostUseCase,
    private val getPostsByIdUseCase: GetPostsByIdUseCase,
    private val postCreatPostsUseCase: PostCreatPostsUseCase,
    private val putChangePostsUseCase: PutChangePostsUseCase
): ViewModel() {

    private val _allPostsResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostResponse: LiveData<NetworkResult<List<PostResponse>>>
        get() = _allPostsResponse
    // private val token = "Yuliya Bobrova Lorithie"
    init {
        getAllPosts()
    }

    private fun getAllPosts(){
        viewModelScope.launch {
            getAllPostUseCase.invoke(token = "Yuliya Bobrova Lorithie")?.let {
                _allPostsResponse.value = it
            }
        }
    }
    private fun getPostsById(){
        viewModelScope.launch {
            getPostsByIdUseCase.invoke(token = "Yuliya Bobrova Lorithie",id = "1")
        }
    }

    fun postCreatPosts(){
        viewModelScope.launch {
            postCreatPostsUseCase.invoke(token = "Yuliya Bobrova Lorithie",body = PostResponse())
        }
    }
    fun putChangePosts(){
        viewModelScope.launch {
            putChangePostsUseCase.invoke(token = "Yuliya Bobrova Lorithie",id = "1").let {
                Log.d("checkdata","data: ${it.data}")
            }
        }
    }
    fun deletePosts(){
        viewModelScope.launch {
            deletePostsUseCase.invoke(token = "Yuliya Bobrova Lorithie",id = "1").let {
                Log.d("checkdata","data: ${it.data}")
            }
        }
    }
}