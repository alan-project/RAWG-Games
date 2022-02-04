package net.alanproject.domain.usecases

import net.alanproject.domain.model.response.Game
import net.alanproject.domain.util.Resource

interface GetGame {
    suspend fun get(
        id: Int
    ): Resource<Game>
}