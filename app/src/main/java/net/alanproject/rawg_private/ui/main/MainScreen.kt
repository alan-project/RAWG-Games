package net.alanproject.rawg_private.ui.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import net.alanproject.domain.model.list.Game
import net.alanproject.rawg_private.R
import net.alanproject.rawg_private.common.RetrySection
import net.alanproject.rawg_private.common.VERTICAL_GAME_NUMBER
import net.alanproject.rawg_private.ui.theme.*
import net.alanproject.rawg_private.ui.widget.Rating
import timber.log.Timber


@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel<MainViewModel>()
) {

    val newTrendingList by remember { viewModel.trendingListState }
    val hotList by remember { viewModel.hotListState }
    val upcomingList by remember { viewModel.upcomingListState }
    val releaseList by remember { viewModel.newReleaseListState }

    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }


    Timber.d("newTrendingList: $newTrendingList")
    Timber.d("hotList: $hotList")
    Timber.d("upcomingList: $upcomingList")

    viewModel.onLoadGames()

    Scaffold(topBar = { AppBar() }) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(start = 12.dp, end = 12.dp)

        ) {
            NewTrending(newTrendingList, navController, text = "New & Trending")
            HotNowGames(upcomingList, navController, text = "What's Hot Now", gameCnt = null)
            Ranking(hotList, navController, text = "Ranking", gameCnt = VERTICAL_GAME_NUMBER)
            PopularGames(upcomingList, navController, text = "Popular", gameCnt = null)

        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if(isLoading) {
                CircularProgressIndicator(color = Yellow200)
            }
            if(loadError.isNotEmpty()) {
                RetrySection(error = loadError) {
                    viewModel.onLoadGames()
                }
            }
        }
    }
}

@Composable
fun NewTrending(
    games: List<Game>?,
    navController: NavHostController?,
    text: String
) {
    TopContent(games, navController, text)
}

@Composable
fun Ranking(
    games: List<Game>?,
    navController: NavHostController?,
    text: String,
    gameCnt: Int
) {
    if (!games.isNullOrEmpty()) {

        MainTitleText(text) { navController?.navigate("list/2") }
        Surface(
            color = Charcoal500,
            elevation = 8.dp
        ) {

            VerticalList(games, navController, gameCnt)
        }
    }
}

@Composable
fun HotNowGames(
    games: List<Game>?,
    navController: NavHostController?,
    gameCnt: Int?,
    text: String
) {
    val modifier = Modifier
        .width(240.dp)
        .wrapContentHeight()
        .padding(4.dp)

    if (!games.isNullOrEmpty()) {
        MainTitleText(text) { navController?.navigate("list/1") }

        Surface(
            color = Charcoal500,
            elevation = 8.dp,
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                SubTitleText(title = "New Release") {
                    navController?.navigate("list/1")
                }
                HorizontalList(games, navController, modifier, gameCnt)
                SubTitleText(title = "Upcoming Games") {
                    navController?.navigate("list/2")
                }
                HorizontalList(games, navController, modifier, gameCnt)

            }
        }
    }
}

@Composable
fun PopularGames(
    games: List<Game>?,
    navController: NavHostController?,
    text: String,
    gameCnt: Int?
) {

    val modifier = Modifier
        .width(240.dp)
        .wrapContentHeight()
        .padding(4.dp)
    if (!games.isNullOrEmpty()) {
        MainTitleText(text) { navController?.navigate("list/3") }

        Surface(
            color = Charcoal500,
            elevation = 8.dp,
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                SubTitleText(title = "Action / Adventure / RPG") {
                    navController?.navigate("list/3")
                }
                HorizontalList(games, navController, modifier, gameCnt)
                SubTitleText(title = "Strategy / Simulation") {
                    navController?.navigate("list/3")
                }
                HorizontalList(games, navController, modifier, gameCnt)
                SubTitleText(title = "Puzzle / Arcade") {
                    navController?.navigate("list/3")
                }
                HorizontalList(games, navController, modifier, gameCnt)
                SubTitleText(title = "Racing / Sports") {
                    navController?.navigate("list/3")
                }
                HorizontalList(games, navController, modifier, gameCnt)
            }
        }

    }
}

@Composable
fun TopContent(
    games: List<Game>?,
    navController: NavHostController?,
    text: String
) {

    val displayedGame = games?.firstOrNull()
    if (displayedGame != null) {
        MainTitleText(text) {}

        Surface(
            color = Charcoal500,
            elevation = 8.dp,

        ) {
            val clickAction: () -> Unit = { navController?.navigate("detail/${displayedGame?.id}") }
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(align = Alignment.Top)
                    .clickable(onClick = { clickAction.invoke() })
                    .padding(8.dp),
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
}

@Composable
fun VerticalList(
    games: List<Game>,
    navController: NavHostController?,
    gameCnt: Int
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        val displayedGames = games.take(gameCnt)


        displayedGames.forEach { game ->
            val clickAction: () -> Unit = { navController?.navigate("detail/${game.id}") }

            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, bottom = 6.dp)
                    .clickable(onClick = { clickAction.invoke() })
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .background(color = Charcoal200)
                        .width(120.dp)
                        .height(80.dp)
                ) {

                    GameScreen(
                        game, modifier = Modifier
                            .width(120.dp)
                            .height(80.dp)
                    )
                    GameDescription(
                        game,
                        modifier = Modifier
                            .height(80.dp)
                            .padding(8.dp),
                        style = TextStyle(color = Color.White, fontSize = 16.sp),

                        )
                }
            }


        }
    }
}


@Composable
fun HorizontalList(
    games: List<Game>,
    navController: NavHostController?,
    modifier: Modifier,
    gameCnt: Int?
) {

    val displayedGames: List<Game> = games.take(gameCnt ?: games.size)

    LazyRow {
        items(displayedGames) { game ->
            val clickAction: () -> Unit = { navController?.navigate("detail/${game.id}") }
            Card(

                shape = RoundedCornerShape(15.dp),
                elevation = 2.dp,
                modifier = modifier
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

@Composable
fun MainTitleText(title: String, clickAction: () -> Unit) {

    Text(
        text = title,
        style = TextStyle(fontSize = 20.sp, color = Yellow200, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
    )

}

@Composable
fun SubTitleText(title: String, clickAction: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clickable(onClick = { clickAction.invoke() }),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = Yellow200,
            modifier = Modifier
                .height(28.dp)
                .width(2.dp)
        )
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "SEE MORE",
            color = Color.Blue,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            ),
            modifier = Modifier.padding(8.dp)
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
        Rating(score = game.rating, modifier = Modifier.align(Alignment.TopEnd))
    }

}

@Composable
fun GameDescription(game: Game, modifier: Modifier, style: TextStyle) {

    val painterRating = rememberImagePainter(R.drawable.rating)
    val painterMeta = rememberImagePainter(R.drawable.meta)
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
        modifier = modifier

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterRating,
                contentDescription = null,
                modifier = Modifier
                    .size(12.dp)
//                    .padding(start = 6.dp)

            )
            Text(
                text = game.rating.toString(),
                style = TextStyle(color = Color.White, fontSize = 12.sp),
                modifier = Modifier.padding(start = 4.dp)
            )
            Image(
                painter = painterMeta,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .padding(start = 8.dp)
            )
            Text(
                text = game.metacritic.toString(),
                style = TextStyle(color = Color.White, fontSize = 12.sp),
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Text(
            text = game.name,
            style = style,
//            modifier = modifier,
            maxLines = 1, overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Release: ${game.released}",
            style = TextStyle(fontSize = 12.sp),
            color = Grey200,
//            modifier = modifier,
            maxLines = 1
        )
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





