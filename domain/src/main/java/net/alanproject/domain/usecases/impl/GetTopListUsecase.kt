package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.list.Result
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetTopList
import javax.inject.Inject

class GetTopListUsecase @Inject constructor(
    private val rawgRepository: RawgRepository
):GetTopList {
    override suspend fun getTopList(): List<Result> {
        return rawgRepository.getTopList().results
    }
}