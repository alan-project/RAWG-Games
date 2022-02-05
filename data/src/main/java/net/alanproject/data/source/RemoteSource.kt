package net.alanproject.data.source

import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.model.response.list.Response

interface RemoteSource {
    suspend fun getGames(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?,
    genres:String?
    ): Response

    suspend fun getGame(
        id: Int
    ): GameDetail
}