package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.response.list.Response
import net.alanproject.domain.model.response.screenshots.Screenshots
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetScreenshots
import net.alanproject.domain.util.Resource
import timber.log.Timber
import javax.inject.Inject

class GetScreenshotsUsecase @Inject constructor(
    private val rawgRepository: RawgRepository
):GetScreenshots {
    override suspend fun get(id: Int): Resource<Screenshots> {

        Timber.d("screenShotErr")
        val response = try{
            rawgRepository.getScreenshots(id)
        }catch(e:Exception){
            Timber.e("screenShotErr e: $e")
            return Resource.Error("An unknown error occured")
        }

        Timber.d("screenShotErr response: ${response}")
        return Resource.Success(response)
    }
}