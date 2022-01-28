package net.alanproject.data.repository

import net.alanproject.data.source.remote.RemoteSourceImpl
import net.alanproject.domain.model.list.Response
import net.alanproject.domain.repository.RawgRepository
import javax.inject.Inject

class RawgRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteSourceImpl
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
}