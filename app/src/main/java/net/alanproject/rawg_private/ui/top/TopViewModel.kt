package net.alanproject.rawg_private.ui.top

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Result
import net.alanproject.domain.usecases.GetTopList
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    private val getTopList: GetTopList
):ViewModel() {

    val topListState: MutableState<List<Result>> = mutableStateOf(listOf())

    init{
        viewModelScope.launch(Dispatchers.IO) {
            val topList = getList()
            topListState.value = topList
        }
    }

    private fun getList(): List<Result> {
        return getTopList.getTopList()
    }
}