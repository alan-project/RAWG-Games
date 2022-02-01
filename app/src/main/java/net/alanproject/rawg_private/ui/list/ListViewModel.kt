package net.alanproject.rawg_private.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.domain.util.Resource
import net.alanproject.rawg_private.common.Constants.Companion.HOT_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.TRENDING_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PERIOD
import net.alanproject.rawg_private.common.mapToPeriod
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getGames: GetGames,
) : ViewModel() {

    val listState: MutableState<List<Game>> = mutableStateOf(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun onLoadGames(categoryId: Int) {

        val period = mapToPeriod(categoryId)

        Timber.d("categoryId: $categoryId")
        try {
            viewModelScope.launch {
                fetchResource(listState, period)
            }
        } catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }

    private suspend fun fetchResource(games: MutableState<List<Game>>, dates: String) {
        isLoading.value = true
        val result = getGames.get(dates = dates)
        when (result) {
            is Resource.Success -> {
                games.value = result.data ?: listOf()
                loadError.value = ""
                isLoading.value = false

            }
            is Resource.Error -> {
                loadError.value = result.message!!
                isLoading.value = false
            }
        }
    }

    @Composable
    fun RetrySection(
        error: String,
        onRetry: () -> Unit
    ) {
        Timber.d("Retry")
        Column {
            Text(error, color = Color.Red, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { onRetry() },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Retry")
            }
        }
    }

}