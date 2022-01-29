package net.alanproject.rawg_private.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.rawg_private.common.*
import net.alanproject.rawg_private.common.Constants.Companion.HOT_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.TRENDING_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PERIOD
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    val newTrendingList: MutableState<List<Game>> = mutableStateOf(listOf())
    val hotListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val upcomingListState: MutableState<List<Game>> = mutableStateOf(listOf())

    init{

        try{
            viewModelScope.launch {
                val newTrendingDeferred = async {
                    getGames.get(dates = TRENDING_PERIOD)
                }
                val hotDeferred = async {
                    getGames.get(dates = HOT_PERIOD)
                }
                val upcomingDeferred = async {
                    getGames.get(dates = UPCOMING_PERIOD)
                }


                newTrendingList.value = newTrendingDeferred.await()
                hotListState.value = hotDeferred.await()
                upcomingListState.value = upcomingDeferred.await()
            }

        }catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }

}