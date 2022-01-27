package net.alanproject.data.repository

import net.alanproject.data.source.remote.RemoteSourceImpl
import net.alanproject.domain.model.list.GameList
import net.alanproject.domain.repository.RawgRepository
import javax.inject.Inject

class RawgRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteSourceImpl
) : RawgRepository {
    override suspend fun getList(
        page: Int,
        order: String,
        dates: String,
        platforms: String?
    ): GameList {
        return remoteSource.getList(
            page,
            order,
            dates,
            platforms
        )
    }
}