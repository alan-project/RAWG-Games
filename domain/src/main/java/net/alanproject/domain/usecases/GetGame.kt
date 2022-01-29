package net.alanproject.domain.usecases

import net.alanproject.domain.model.list.Game

interface GetGame {
    suspend fun get(
        id: Int
    ): Game
}