package net.alanproject.domain.usecases

import net.alanproject.domain.model.list.Result

interface GetTopList {
    suspend fun getTopList():List<Result>
}