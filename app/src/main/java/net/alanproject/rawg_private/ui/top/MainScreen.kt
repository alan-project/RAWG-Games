package net.alanproject.rawg_private.ui.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import net.alanproject.domain.model.list.Result
import net.alanproject.rawg_private.ui.theme.Rawg_privateTheme
import timber.log.Timber


@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()
    val newTrendingList = viewModel.newTrendingState.value
    val hotList = viewModel.hotState.value
    val upcomingList = viewModel.upcomingState.value

    Timber.d("newTrendingList: $newTrendingList")
    Timber.d("hotList: $hotList")
    Timber.d("upcomingList: $upcomingList")

    Scaffold(topBar = { AppBar() }) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())

        ) {
            if (newTrendingList.isNotEmpty()) FullBanner(newTrendingList)
            if (hotList.isNotEmpty()) VerticalList(hotList, 3)
            if (upcomingList.isNotEmpty()) HorizontalList(upcomingList, 5)
        }
    }


}

@Composable
fun FullBanner(games: List<Result>) {
    val game: Result = games[0]
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            FullImage(game)
            CustomImageDes(game)
        }
    }
}

@Composable
fun FullImage(game: Result) {
    val scrUrl: String = game.backgroundImage
    Image(
        //loaded asynchronously
        painter = rememberImagePainter(
            data = scrUrl,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentDescription = "Profile picture description",
    )
}

@Composable
fun CustomImageDes(game: Result) {
    Text(text = game.name)
}

@Composable
fun VerticalList(games: List<Result>, gameCnt: Int) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        for (i in 0 until gameCnt) {
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(4.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(games[i].backgroundImage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(88.dp)
                            .padding(4.dp)
                    )

                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = games[i].name,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HorizontalList(games: List<Result>, gameCnt: Int) {

    val selectedGames = games.subList(0, gameCnt)

    LazyRow {
        items(selectedGames) { game ->
            GameCard(game = game)
        }
    }
}

@Composable
fun GameCard(game: Result) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 2.dp,
            modifier = Modifier
                .width(200.dp)
                .height(220.dp)

               // .padding(top = 16.dp)
        ) {

            Column(
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = rememberImagePainter(game.backgroundImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(180.dp)
                        .padding(4.dp)
                )
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.h6
                )
            }
        }

    }
}

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Settings,
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 12.dp),
            )
        },
        title = { Text("APPLICATION NAME") }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Rawg_privateTheme {
        MainScreen()
    }
}