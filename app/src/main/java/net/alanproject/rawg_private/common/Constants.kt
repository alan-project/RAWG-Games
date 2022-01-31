package net.alanproject.rawg_private.common


class Constants{
    companion object{
        val TRENDING_PERIOD:String = dateParsing(past=true, ONE_WEEK)
        val HOT_PERIOD:String = dateParsing(past=true, SIX_MONTH)
        val UPCOMING_PERIOD:String = dateParsing(past=false, ONE_MONTH)
        val RELEASE_PERIOD:String = dateParsing(past=true, ONE_MONTH)
    }
}

const val BASE_URL = "https://api.rawg.io/api/"
const val VERTICAL_GAME_NUMBER = 3
const val HORIZONTAL_GAME_NUMBER = 5
const val ONE_WEEK = 7L
const val ONE_MONTH = 30L
const val TWO_MONTH = 60L
const val THREE_MONTH = 90L
const val SIX_MONTH = 180L
const val ONE_YEAR = 365L
