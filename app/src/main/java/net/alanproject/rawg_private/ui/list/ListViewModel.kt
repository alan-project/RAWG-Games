package net.alanproject.rawg_private.ui.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.rawg_private.common.Constants.Companion.HOT_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.TRENDING_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PERIOD
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getGames: GetGames,
) : ViewModel() {

    val listState: MutableState<List<Game>> = mutableStateOf(listOf())

    fun getList(categoryId: Int) {

        val period = when (categoryId) {
            1 -> TRENDING_PERIOD
            2 -> HOT_PERIOD
            3 -> UPCOMING_PERIOD
            else -> {
                TRENDING_PERIOD
            }
        }

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