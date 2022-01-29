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
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getGame: GetGame,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val gameState: MutableState<Game> = mutableStateOf(Game())
    private val id: Int? = savedStateHandle.get("id")

    init {
        try {
            viewModelScope.launch {
                val gameDeferred = async {
                    id?.let{
                        getGame.get(it)
                    }
                }
                gameState.value = gameDeferred.await()?:Game()
            }
        } catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }

    }

}