package net.alanproject.domain.model.list


import com.google.gson.annotations.SerializedName

data class Rating(
    val id: Int = 0,
    val title: String = "",
    val count: Int = 0,
    val percent: Double = 0.0
)