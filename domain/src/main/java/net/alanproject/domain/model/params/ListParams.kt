package net.alanproject.domain.model.params

import com.google.gson.Gson

data class ListParams(

    val period: String? = null,
    val genres: String? = null,
    val ordering: String? = "-added",
    val platforms: String? = null,

)

fun listParamsToJsonString(listParams: ListParams):String{
    val gson = Gson()
    return gson.toJson(listParams)
}
