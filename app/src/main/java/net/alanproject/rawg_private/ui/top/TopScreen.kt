package net.alanproject.rawg_private.ui.top

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import net.alanproject.rawg_private.ui.theme.Rawg_privateTheme


@Composable
fun TopScreen(){
    val viewModel: TopViewModel = viewModel()
    val topGames = viewModel.topListState.value
    
    LazyColumn(){
        items(topGames){games->
            Text(text = games.name)
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Rawg_privateTheme {
        TopScreen()
    }
}