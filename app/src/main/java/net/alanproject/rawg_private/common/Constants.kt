package net.alanproject.rawg_private.common

import net.alanproject.domain.model.params.ListParams


class Constants {
    companion object {
        //Period
        val TRENDING_PERIOD: String = dateParsing(past = true, ONE_WEEK)
        val RANK_PERIOD: String = dateParsing(past = true, SIX_MONTH)
        val UPCOMING_PERIOD: String = dateParsing(past = false, ONE_MONTH)
        val RELEASE_PERIOD: String = dateParsing(past = true, ONE_MONTH)
        val GENRES_PERIOD: String = dateParsing(past = true, SIX_MONTH)

        //Genres
        val ACTION: String = "2,3,4,5"
        val STRATEGY: String = "10,14"
        val PUZZLE: String = "7,11,28,17"
        val RACING: String = "1,15"

        //Platforms
        val PC: String = "4,5,6"
        val CONSOLE: String = "187,18,16,15,27,19,17,1,186,14,80,83,7,8,9,13,10,11"
        val MOBILE: String = "3,21"
        val XBOX: String = "1,14,80,186"
        val PS: String = "187,18,16,15,27,19,17"
        val NINTENDO: String = "83,7,8,9,13,10,11"


        val DEFAULT_PARAMS: ListParams = ListParams(
            period = RANK_PERIOD,
            genres = null,
            ordering = "-added",
            isFromMain = false
        )

        val TRENDING_PARAMS: ListParams = ListParams(
            period = TRENDING_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true,
        )

        val RELEASE_PARAMS: ListParams = ListParams(
            period = RELEASE_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true,
            mainTitle = "Top 20 New Games",
            subTitle = "most popular games released last month"
        )

        val UPCOMING_PARAMS: ListParams = ListParams(
            period = UPCOMING_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true,
            mainTitle = "Top 20 Upcoming Games",
            subTitle = "most popular games coming out next month"
        )

        val RANK_PARAMS: ListParams = ListParams(
            period = RANK_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true
        )

        val ACTION_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            genres = ACTION,
            ordering = null,
            isFromMain = true,
            mainTitle = "Top 20 Action Games",
            subTitle = "most popular action, adventure, rpg games over the last six months"
        )
        val STRATEGY_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            genres = STRATEGY,
            ordering = null,
            isFromMain = true,
            mainTitle = "Top 20 Strategy Games",
            subTitle = "most popular strategy, simulation games over the last six months"
        )
        val PUZZLE_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            genres = PUZZLE,
            ordering = null,
            isFromMain = true,
            mainTitle = "Top 20 Puzzle Games",
            subTitle = "most popular puzzle, arcade games over the last six months"
        )
        val RACING_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            genres = RACING,
            ordering = null,
            isFromMain = true,
            mainTitle = "Top 20 Racing Games",
            subTitle = "most popular racing, sports games over the last six months"
        )

        //Platforms
        val PC_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            ordering = null,
            platforms = PC,
            isFromMain = true,
            mainTitle = "Top 20 PC Games",
            subTitle = "most popular PC games over the last six months"
        )
        val CONSOLE_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            ordering = null,
            platforms = CONSOLE,
            isFromMain = true,
            mainTitle = "Top 20 Console Games",
            subTitle = "most popular Console games over the last six months"
        )
        val PS_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            ordering = null,
            platforms = PS,
            isFromMain = true,
            mainTitle = "Top 20 Play Station Games",
            subTitle = "most popular PS games over the last six months"
        )
        val XBOX_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            ordering = null,
            platforms = XBOX,
            isFromMain = true,
            mainTitle = "Top 20 Xbox Games",
            subTitle = "most popular Xbox games over the last six months"
        )
        val NINTENDO_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            ordering = null,
            platforms = NINTENDO,
            isFromMain = true
        )
        val MOBILE_PARAMS: ListParams = ListParams(
            period = GENRES_PERIOD,
            ordering = null,
            platforms = MOBILE,
            isFromMain = true,
            mainTitle = "Top 20 Android/IOS Games",
            subTitle = "most popular Mobile games over the last six months"
        )

    }
}


const val BASE_URL = "https://api.rawg.io/api/"
const val PAGE_SIZE = 20
const val HORIZONTAL_GAME_NUMBER = 5
const val ONE_WEEK = 7L
const val ONE_MONTH = 30L
const val TWO_MONTH = 60L
const val THREE_MONTH = 90L
const val SIX_MONTH = 180L
const val ONE_YEAR = 365L

const val MINIMIZED_MAX_LINES = 4