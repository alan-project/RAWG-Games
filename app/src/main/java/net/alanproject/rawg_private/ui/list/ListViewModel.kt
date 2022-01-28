package net.alanproject.rawg_private.ui.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.rawg_private.common.Constants
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getGames: GetGames,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val listState: MutableState<List<Game>> = mutableStateOf(listOf())
    private val categoryId: Long? = savedStateHandle.get("categoryId")
    private val period = when (categoryId?.toInt()) {
        1 -> Constants.TRENDING_PERIOD
        2 -> Constants.HOT_PERIOD
        3 -> Constants.UPCOMING_PERIOD
        else -> {
            Constants.TRENDING_PERIOD
        }
    }

    init {
        Timber.d("categoryId: $categoryId")
        try {
            viewModelScope.launch {
                val newTrendingDeferred = async {
                    getGames.get(dates = period)
                }
                listState.value = newTrendingDeferred.await()
            }
        } catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }
}