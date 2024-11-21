package com.example.eisenhowermatrix.data.Api


import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("importance")
    val importance: String? = null,
    @SerializedName("deadline")
    val deadline: Int? = null,
    @SerializedName("done")
    val done: Boolean? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("created_at")
    val created_at: String? = null,
    @SerializedName("changed_at")
    val changed_at: String? = null,
    @SerializedName("last_updated_by")
    val last_updated_by: String? = null,
    //@SerializedName("body")
    // val body: String? = null



)
