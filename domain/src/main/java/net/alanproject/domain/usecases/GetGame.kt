package net.alanproject.domain.usecases

import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.util.Resource

interface GetGame {
    suspend fun get(
        id: Int
    ): Resource<GameDetail>
}