package net.alanproject.data.repository

import net.alanproject.data.source.RemoteSource
import net.alanproject.data.source.remote.RemoteSourceImpl
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.model.list.Response
import net.alanproject.domain.repository.RawgRepository
import javax.inject.Inject

class RawgRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteSource
) : RawgRepository {
    override suspend fun getGames(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?
    ): Response {
        return remoteSource.getGames(
            page,
            order,
            dates,
            platforms
        )
    }

    override suspend fun getGame(id: Int): Game {
        return remoteSource.getGame(id)
    }
}