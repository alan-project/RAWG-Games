package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.list.Game
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetGames
import javax.inject.Inject

class GetGamesUsecase @Inject constructor(
    private val rawgRepository: RawgRepository
) : GetGames {
    override suspend fun get(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?
    ): List<Game> {
        return rawgRepository.getGames(
            page, order, dates, platforms
        ).results
    }

}