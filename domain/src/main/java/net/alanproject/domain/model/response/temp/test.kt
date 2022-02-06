package net.alanproject.domain.model.response.temp


import com.google.gson.annotations.SerializedName

data class test(
    val count: Int = 0,
    val next: Any = Any(),
    val previous: Any = Any(),
    val results: List<Result> = listOf()
)