package net.alanproject.domain.model.response.detail


import com.google.gson.annotations.SerializedName

data class Store(
    val id: Int = 0,
    val url: String = "",
    val store: StoreX = StoreX()
)