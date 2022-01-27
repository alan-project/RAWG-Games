package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.list.Result
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetList
import javax.inject.Inject

class GetListUsecase @Inject constructor(
    private val rawgRepository: RawgRepository
) : GetList {
    override suspend fun getList(
        page: Int,
        order: String,
        dates: String,
        platforms: String?
    ): List<Result> {
        return rawgRepository.getList(
            page, order, dates, platforms
        ).results
    }
}