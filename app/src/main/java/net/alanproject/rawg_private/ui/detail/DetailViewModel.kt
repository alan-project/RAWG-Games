package net.alanproject.rawg_private.ui.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.usecases.GetGame
import net.alanproject.domain.util.Resource
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getGame: GetGame,
) : ViewModel() {

    val gameState: MutableState<Game> = mutableStateOf(Game())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun onLoadGame(gameId:Int){
        try {
            viewModelScope.launch {
                fetchResource(gameState, gameId)
            }
        } catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }

    private suspend fun fetchResource(gameState: MutableState<Game>, gameId: Int) {
        isLoading.value = true
        val result = getGame.get(gameId)
        when (result) {
            is Resource.Success -> {
                gameState.value = result.data?:Game()
                loadError.value = ""
                isLoading.value = false

            }
            is Resource.Error -> {
                loadError.value = result.message!!
                isLoading.value = false
            }
        }
    }
}