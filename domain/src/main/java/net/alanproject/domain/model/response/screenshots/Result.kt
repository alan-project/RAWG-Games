package net.alanproject.domain.model.response.screenshots


import com.google.gson.annotations.SerializedName

data class Result(
    val id: Int = 0,
    val image: String = "",
    val width: Int = 0,
    val height: Int = 0,
    @SerializedName("is_deleted")
    val isDeleted: Boolean = false
)