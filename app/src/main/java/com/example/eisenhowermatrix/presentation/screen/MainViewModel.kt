package com.example.eisenhowermatrix.presentation.screen


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eisenhowermatrix.data.Api.NoteResponse
import com.example.eisenhowermatrix.domain.DeleteNotesUseCase
import com.example.eisenhowermatrix.domain.GetAllNotesUseCase
import com.example.eisenhowermatrix.domain.GetNotesByIdUseCase
import com.example.eisenhowermatrix.domain.PostCreatNotesUseCase
import com.example.eisenhowermatrix.domain.PutChangeNotesUseCase
import com.example.eisenhowermatrix.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val deleteNotesUseCase: DeleteNotesUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val getNotesByIdUseCase: GetNotesByIdUseCase,
    private val postCreatNotesUseCase: PostCreatNotesUseCase,
    private val putChangeNotesUseCase: PutChangeNotesUseCase
): ViewModel() {

    private val _allNotesResponse = MutableLiveData<NetworkResult<List<NoteResponse>>>()
    val allNoteResponse: LiveData<NetworkResult<List<NoteResponse>>>
        get() = _allNotesResponse
    // private val token = "Yuliya Bobrova Lorithie"
    init {
        getAllNotes()
    }

    private fun getAllNotes(){
        viewModelScope.launch {
            getAllNotesUseCase.invoke(token = /*"Yuliya Bobrova*/ "Lorithie")?.let {
                _allNotesResponse.value = it
            }
        }
    }
    private fun getNotesById(){
        viewModelScope.launch {
            getNotesByIdUseCase.invoke(token = /*Yuliya Bobrova*/ "Lorithie",id = "1")
        }
    }

    fun postCreatNotes(){
        viewModelScope.launch {
            postCreatNotesUseCase.invoke(token = /*"Yuliya Bobrova*/ "Lorithie",id = "1"/*body = NoteResponse(body = "start" )*/)
        }
    }
    fun putChangeNotes(){
        viewModelScope.launch {
            putChangeNotesUseCase.invoke(token = /*"Yuliya Bobrova*/ "Lorithie",id = "1").let {
                Log.d("checkdata","data: ${it.data}")
            }
        }
    }
    fun deleteNotes(){
        viewModelScope.launch {
            deleteNotesUseCase.invoke(token = /*"Yuliya Bobrova*/ "Lorithie",id = "1").let {
                Log.d("checkdata","data: ${it.data}")
            }
        }
    }
}