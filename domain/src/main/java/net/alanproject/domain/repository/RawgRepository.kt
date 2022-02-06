package net.alanproject.domain.repository

import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.model.response.list.Response
import net.alanproject.domain.model.response.screenshots.Screenshots

interface RawgRepository {
    suspend fun getGames(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Response

    suspend fun getGame(
        id: Int
    ): GameDetail

    suspend fun getScreenshots(
        id: Int
    ): Screenshots
}