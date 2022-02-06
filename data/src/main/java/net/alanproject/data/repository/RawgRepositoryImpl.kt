package net.alanproject.data.repository

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.model.response.list.Response
import net.alanproject.domain.model.response.screenshots.Screenshots
import net.alanproject.domain.repository.RawgRepository
import timber.log.Timber
import javax.inject.Inject

class RawgRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteSource
) : RawgRepository {
    override suspend fun getGames(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?,
        genres:String?
    ): Response {
        return remoteSource.getGames(
            page,
            order,
            dates,
            platforms,
            genres
        )
    }

    override suspend fun getGame(id: Int): GameDetail {
        return remoteSource.getGame(id)
    }

    override suspend fun getScreenshots(id: Int): Screenshots {
        Timber.d("screenShotErr: id: $id")
        return remoteSource.getScreenshots(id)
    }
}