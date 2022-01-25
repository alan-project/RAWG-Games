package net.alanproject.domain.model.list


import com.google.gson.annotations.SerializedName

data class YearX(
    val year: Int = 0,
    val count: Int = 0,
    val nofollow: Boolean = false
)