package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.params.ListParams
import net.alanproject.domain.model.response.list.Response
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetGames
import net.alanproject.domain.util.Resource
import javax.inject.Inject

class GetGamesUsecase @Inject constructor(
    private val rawgRepository: RawgRepository
) : GetGames {
    override suspend fun get(
        page: Int?,
        params: ListParams
    ): Resource<Response> {
        val response = try {
            rawgRepository.getGames(
                page,
                order = params.ordering,
                dates = params.period,
                platforms = params.platforms,
                genres = params.genres
            )
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

}