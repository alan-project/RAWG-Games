package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.list.Game
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetGame
import javax.inject.Inject

class GetGameUsecase @Inject constructor(
    private val rawgRepository: RawgRepository
):GetGame {
    override suspend fun get(id: Int): Game {
        return rawgRepository.getGame(id)
    }

}