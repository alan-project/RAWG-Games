package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetGame
import net.alanproject.domain.util.Resource
import javax.inject.Inject

class GetGameUsecase @Inject constructor(
    private val rawgRepository: RawgRepository
): GetGame {
    override suspend fun get(id: Int): Resource<GameDetail> {
        val response = try{
            rawgRepository.getGame(id)
        }catch(e:Exception){
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }

}