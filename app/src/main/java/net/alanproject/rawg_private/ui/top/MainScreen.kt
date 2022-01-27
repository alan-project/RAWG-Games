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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
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
            if (newTrendingList.isNotEmpty()) FullBanner(newTrendingList, 0)
            if (hotList.isNotEmpty()) VerticalList(hotList, 3)
            if (upcomingList.isNotEmpty()) HorizontalList(upcomingList, 5)
        }
    }


}

@Composable
fun FullBanner(games: List<Result>, index: Int) {
    val game: Result = games[index]
    TitleText("New & Trending")
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
fun TitleText(title: String) {
    Text(
        text = title,
        color = Color.White,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun FullImage(game: Result) {
    val scrUrl: String = game.backgroundImage
    Image(
        //loaded asynchronously
        painter = rememberImagePainter(
            data = scrUrl,
            builder = {
                transformations(
                    RoundedCornersTransformation(),
                )
            }
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

    TitleText("What's Hot Now")
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
                        painter = rememberImagePainter(
                            data = games[i].backgroundImage,
                            builder = {
                                transformations(
                                    RoundedCornersTransformation(),
                                )
                            }),
                        contentDescription = null,
                        modifier = Modifier
                            .width(120.dp)
                            .height(80.dp)
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

    TitleText("Upcoming Games")
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
                .width(240.dp)
                .wrapContentHeight()

            // .padding(top = 16.dp)
        ) {

            Column(
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = rememberImagePainter(game.backgroundImage,
                        builder = {
                            transformations(
                                RoundedCornersTransformation(),
                            )
                        }),
                    contentDescription = null,
                    modifier = Modifier
                        .width(220.dp)
                        .height(160.dp)
                        .padding(4.dp)
                )
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1, overflow = TextOverflow.Ellipsis
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