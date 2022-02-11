package net.alanproject.domain.model.params

import com.google.gson.Gson

data class ListParams(

    val period: String? = null,
    val genres: String? = null,
    val ordering: String? = "-added",
    val platforms: String? = null,
    val isFromMain: Boolean = false,
    val mainTitle:String? = null,
    val subTitle:String? = null

)

fun listParamsToJsonString(listParams: ListParams):String{
    val gson = Gson()
    return gson.toJson(listParams)
}
