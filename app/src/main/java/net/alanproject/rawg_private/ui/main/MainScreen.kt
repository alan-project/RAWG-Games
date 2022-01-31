package net.alanproject.rawg_private.ui.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import net.alanproject.domain.model.list.Game
import net.alanproject.rawg_private.common.HORIZONTAL_GAME_NUMBER
import net.alanproject.rawg_private.common.VERTICAL_GAME_NUMBER
import net.alanproject.rawg_private.ui.theme.Rawg_privateTheme
import timber.log.Timber


@Composable
fun MainScreen(navController: NavHostController?) {
    val viewModel = hiltViewModel<MainViewModel>()

    val newTrendingList = viewModel.newTrendingList.value
    val hotList = viewModel.hotListState.value
    val upcomingList = viewModel.upcomingListState.value
    val releaseList = viewModel.newReleaseListState.value

    Timber.d("newTrendingList: $newTrendingList")
    Timber.d("hotList: $hotList")
    Timber.d("upcomingList: $upcomingList")

    Scaffold(topBar = { AppBar() }) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())

        ) {
            NewTrending(newTrendingList, navController)
            HowNow(hotList, navController, VERTICAL_GAME_NUMBER)
            Upcoming(upcomingList, navController, HORIZONTAL_GAME_NUMBER, "Upcoming Games")
            NewRelease(releaseList, navController, HORIZONTAL_GAME_NUMBER, "New Release")

        }
    }
}

@Composable
fun NewTrending(games: List<Game>?, navController: NavHostController?) =
    TopContent(games, navController)

@Composable
fun HowNow(games: List<Game>?, navController: NavHostController?, gameCnt: Int) =
    VerticalList(games, navController, gameCnt)

@Composable
fun NewRelease(games: List<Game>?, navController: NavHostController?, gameCnt: Int, text: String) =
    HorizontalList(games, navController, gameCnt, text)

@Composable
fun Upcoming(games: List<Game>?, navController: NavHostController?, gameCnt: Int, text: String) =
    HorizontalList(games, navController, gameCnt, text)


@Composable
fun TopContent(games: List<Game>?, navController: NavHostController?) {

    val displayedGame = games?.firstOrNull()
    if (displayedGame != null) {
        TitleText("New & Trending") {
            navController?.navigate("list/1")
        }
        val clickAction: () -> Unit = { navController?.navigate("detail/${displayedGame?.id}") }
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top)
                .clickable(onClick = { clickAction.invoke() })
                .padding(4.dp),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
            GameScreenWithText(
                displayedGame, modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Composable
fun VerticalList(games: List<Game>?, navController: NavHostController?, gameCnt: Int) {

    if (!games.isNullOrEmpty()) {
        TitleText("What's Hot Now") {
            navController?.navigate("list/2")
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            val displayedGames = games.take(gameCnt)

            displayedGames.let { selectedGames ->
                selectedGames.forEach { game ->
                    val clickAction: () -> Unit = { navController?.navigate("detail/${game.id}") }

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        elevation = 2.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .clickable(onClick = { clickAction.invoke() })
                    ) {
                        Row(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(4.dp)
                        ) {

                            GameScreen(
                                game, modifier = Modifier
                                    .width(120.dp)
                                    .height(80.dp)
                                    .padding(4.dp)
                            )
                            GameDescription(game)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun HorizontalList(
    games: List<Game>?,
    navController: NavHostController?,
    gameCnt: Int,
    text: String
) {

    val displayedGames = games?.take(gameCnt)

    if (!displayedGames.isNullOrEmpty()) {
        TitleText(text) {
            navController?.navigate("list/3")
        }
        LazyRow {
            items(displayedGames) { game ->
                val clickAction: () -> Unit = { navController?.navigate("detail/${game.id}") }
                Card(

                    shape = RoundedCornerShape(15.dp),
                    elevation = 2.dp,
                    modifier = Modifier
                        .width(240.dp)
                        .wrapContentHeight()
                        .padding(4.dp)
                        .clickable(onClick = { clickAction.invoke() })
                ) {

                    GameScreenWithText(
                        game,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun TitleText(title: String, clickAction: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { clickAction.invoke() }),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        Icon(
            Icons.Default.ArrowForward,
            contentDescription = "",
            modifier = Modifier.padding(8.dp),
            tint = Color.White
        )
    }
}

@Composable
fun GameScreen(game: Game, modifier: Modifier) {
    Image(
        //loaded asynchronously
        painter = rememberImagePainter(
            data = game.backgroundImage,
            builder = {
                transformations(
                    RoundedCornersTransformation(),
                )
            }
        ),
        modifier = modifier,
        contentDescription = "game picture description",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun GameScreenWithText(game: Game, modifier: Modifier) {
    Box(modifier = modifier) {
        Image(
            //loaded asynchronously
            painter = rememberImagePainter(
                data = game.backgroundImage,
                builder = {
                    transformations(
                        RoundedCornersTransformation(),
                    )
                }
            ),
//            modifier = modifier,
            contentDescription = "game picture description",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
        )
        Text(
            text = game.name,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp),
            style = TextStyle(color = Color.White, fontSize = 16.sp),
        )
    }

}

@Composable
fun GameDescription(game: Game) {
    Text(
        text = game.name,
        style = MaterialTheme.typography.h6,
        maxLines = 1, overflow = TextOverflow.Ellipsis
    )
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
//        MainScreen(MainViewModel(),null)
    }
}