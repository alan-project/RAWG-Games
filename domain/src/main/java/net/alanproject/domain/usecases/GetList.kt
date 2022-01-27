package net.alanproject.domain.usecases

import net.alanproject.domain.model.list.Result

interface GetList {
    suspend fun getList(
        page: Int,
        order: String,
        dates: String,
        platforms: String?
    ): List<Result>
}