package com.example.eisenhowermatrix.utils


sealed class NetworkResult<T> (
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T?): NetworkResult<T>(data)
    class Errror<T>(data: T?, message: String?): NetworkResult<T>(data, message)
    class Loading<T>(): NetworkResult<T>()

}