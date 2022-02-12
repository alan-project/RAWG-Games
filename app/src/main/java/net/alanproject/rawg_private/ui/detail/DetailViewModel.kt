package net.alanproject.rawg_private.ui.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.model.response.screenshots.Screenshots
import net.alanproject.domain.usecases.GetGame
import net.alanproject.domain.usecases.GetScreenshots
import net.alanproject.domain.util.Resource
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getGame: GetGame,
    private val getScreenshots: GetScreenshots
) : ViewModel() {

    val gameState: MutableState<GameDetail> = mutableStateOf(GameDetail())
    val screenshotsState: MutableState<Screenshots> = mutableStateOf(Screenshots())

    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun onLoadGame(gameId: Int) {
        try {

            viewModelScope.launch {
                fetchGameInfo(gameState, gameId)
            }
            viewModelScope.launch {
                fetchGameScreenShots(screenshotsState, gameId)
            }

        } catch (exception: Exception) {
            Timber.e("throwable: $exception")
        }
    }

    private suspend fun fetchGameInfo(gameState: MutableState<GameDetail>, gameId: Int) {
        isLoading.value = true
        val result = getGame.get(gameId)
        when (result) {
            is Resource.Success -> {
                gameState.value = result.data ?: GameDetail()
                loadError.value = ""
                isLoading.value = false

            }
            is Resource.Error -> {
                loadError.value = result.message!!
                isLoading.value = false
            }
        }
    }

    private suspend fun fetchGameScreenShots(
        screenshotState: MutableState<Screenshots>,
        gameId: Int
    ) {
        isLoading.value = true
        val result = getScreenshots.get(gameId)
        when (result) {
            is Resource.Success -> {
                screenshotState.value = result.data ?: Screenshots()
                Timber.d("screenShotErr: screenshotState.value ${screenshotState.value}")
                loadError.value = ""
                isLoading.value = false

            }
            is Resource.Error -> {
                Timber.e("screenShotErr: result.message ${result.message}")
                loadError.value = result.message!!
                isLoading.value = false
            }
        }
    }
}