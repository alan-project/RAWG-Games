package net.alanproject.rawg_private.ui.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import net.alanproject.domain.model.params.listParamsToJsonString
import net.alanproject.domain.model.response.list.Game
import net.alanproject.rawg_private.common.Constants.Companion.ACTION_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.MOBILE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.PC_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.PS_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.PUZZLE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RACING_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RELEASE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.STRATEGY_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.XBOX_PARAMS
import net.alanproject.rawg_private.common.RetrySection
import net.alanproject.rawg_private.ui.theme.Charcoal200
import net.alanproject.rawg_private.ui.theme.Charcoal500
import net.alanproject.rawg_private.ui.theme.Grey200
import net.alanproject.rawg_private.ui.theme.Yellow200
import net.alanproject.rawg_private.ui.widget.*
import timber.log.Timber


@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {

    val trendingGames by remember { viewModel.trendingGamesState }

    val upcomingGames by remember { viewModel.upcomingGamesState }
    val releaseGames by remember { viewModel.releaseGamesState }

    val totalRankGames by remember { viewModel.totalRankGamesState }


    //Genres
    val actionGames by remember { viewModel.actionGamesState }
    val strategyGames by remember { viewModel.strategyGamesState }
    val puzzleGames by remember { viewModel.puzzleGamesState }
    val racingGames by remember { viewModel.racingGamesState }

    //Platform
    val pcGames by remember { viewModel.pcGamesState }
    val psGames by remember { viewModel.psGamesState }
    val xboxGames by remember { viewModel.xboxGamesState }
    val mobileGames by remember { viewModel.mobileGamesState }

    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }

    Timber.d("onLoadGames in View")
    viewModel.onLoadGames()

    Scaffold {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(start = 12.dp, end = 12.dp)

        ) {
            TrendingGames(trendingGames, navController, text = "New & Trending")

            HotGames(
                releaseGames,
                upcomingGames,
                navController,
                gameCnt = null,
                text = "What's Hot Now"
            )

            Ranking(totalRankGames, navController, text = "Total Ranking")


            PopularGamesByGenre(
                actionGames,
                strategyGames,
                puzzleGames,
                racingGames,
                navController,
                text = "Popular by Genres",
                gameCnt = null
            )

            if (!pcGames.isNullOrEmpty() && !mobileGames.isNullOrEmpty()) {
                Timber.d("pcGames: ${pcGames.first().name}, mobileGames: ${mobileGames.first().name}")
            }

            PopularGamesByPlatform(
                pcGames = pcGames,
                psGames = psGames,
                xboxGames = xboxGames,
                mobileGames = mobileGames,
                navController,
                text = "Popular by Platforms",
                gameCnt = null
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Yellow200)
            }
            if (loadError.isNotEmpty()) {
                RetrySection(error = loadError) {
                    viewModel.onLoadGames()
                }
            }
        }

    }


}

@Composable
private fun TrendingGames(
    games: List<Game>?,
    navController: NavHostController?,
    text: String
) {
    if (!games.isNullOrEmpty()) {
        TopContent(games, navController, text)
    }
}

@Composable
private fun Ranking(
    rankGames: List<Game>,
    navController: NavHostController?,
    text: String
) {
    if (!rankGames.isNullOrEmpty()) {
        MainTitleText(text) { navController?.navigate("rank/2") }
        RankGames(rankGames, navController)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewRanking() {
    Ranking(
        listOf(
            Game(name = "game 1"),
            Game(name = "game 2"),
            Game(name = "game 3"),
            Game(name = "game 4"),
            Game(name = "game 5"),
            Game(name = "game 6")
        ), null, "Test"
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewRankGame() {
    RankGame(null, Game(name = "Halo"))
}

@Composable
private fun HotGames(
    releaseGames: List<Game>?,
    upcomingGames: List<Game>?,
    navController: NavHostController?,
    gameCnt: Int?,
    text: String
) {
    val modifier = Modifier
        .width(240.dp)
        .wrapContentHeight()
        .padding(4.dp)

    if (!releaseGames.isNullOrEmpty() || !upcomingGames.isNullOrEmpty()) {
        MainTitleText(text) { navController?.navigate("rank/1") }
    }

    Surface(
        color = Charcoal500,
        elevation = 8.dp,
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            if (!releaseGames.isNullOrEmpty()) {
                SubTitleText(title = "New Release") {
                    Timber.d("[LoadingError] navigate 1")

                    val jsonString = listParamsToJsonString(RELEASE_PARAMS)
                    navController?.navigate("rank/$jsonString/hide")
                }
                HorizontalList(releaseGames, navController, modifier, gameCnt)
            }
            if (!upcomingGames.isNullOrEmpty()) {
                SubTitleText(title = "Upcoming Games") {
                    Timber.d("[LoadingError] navigate 2")
                    val jsonString = listParamsToJsonString(UPCOMING_PARAMS)
                    navController?.navigate("rank/$jsonString/hide")
                }
                HorizontalList(upcomingGames, navController, modifier, gameCnt)
            }
        }
    }
}

@Composable
private fun PopularGamesByGenre(
    actionGames: List<Game>?,
    strategyGames: List<Game>?,
    puzzleGames: List<Game>?,
    racingGames: List<Game>?,
    navController: NavHostController?,
    text: String,
    gameCnt: Int?
) {

    val modifier = Modifier
        .width(240.dp)
        .wrapContentHeight()
        .padding(4.dp)
    if (!actionGames.isNullOrEmpty() || !strategyGames.isNullOrEmpty() || !puzzleGames.isNullOrEmpty() || !racingGames.isNullOrEmpty()) {
        MainTitleText(text) {  }

        Surface(
            color = Charcoal500,
            elevation = 8.dp,
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                if (!actionGames.isNullOrEmpty()) {
                    SubTitleText(title = "Action / Adventure / RPG") {
                        val jsonString = listParamsToJsonString(ACTION_PARAMS)
                        Timber.d("jsonString[Action]: $jsonString")
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(actionGames, navController, modifier, gameCnt)
                }
                if (!strategyGames.isNullOrEmpty()) {
                    SubTitleText(title = "Strategy / Simulation") {
                        val jsonString = listParamsToJsonString(STRATEGY_PARAMS)
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(strategyGames, navController, modifier, gameCnt)
                }
                if (!puzzleGames.isNullOrEmpty()) {

                    SubTitleText(title = "Puzzle / Arcade") {
                        val jsonString = listParamsToJsonString(PUZZLE_PARAMS)
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(puzzleGames, navController, modifier, gameCnt)
                }

                if (!racingGames.isNullOrEmpty()) {
                    SubTitleText(title = "Racing / Sports") {
                        val jsonString = listParamsToJsonString(RACING_PARAMS)
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(racingGames, navController, modifier, gameCnt)
                }
            }

        }
    }
}


@Composable
private fun PopularGamesByPlatform(
    pcGames: List<Game>?,
    psGames: List<Game>?,
    xboxGames: List<Game>?,
    mobileGames: List<Game>?,
    navController: NavHostController?,
    text: String,
    gameCnt: Int?
) {

    val modifier = Modifier
        .width(240.dp)
        .wrapContentHeight()
        .padding(4.dp)

//    if (!pcGames.isNullOrEmpty() || !psGames.isNullOrEmpty() || !xboxGames.isNullOrEmpty() || !mobileGames.isNullOrEmpty()) {
    if (!pcGames.isNullOrEmpty() && !psGames.isNullOrEmpty() && !xboxGames.isNullOrEmpty() && !mobileGames.isNullOrEmpty()) {
        MainTitleText(text) { }

        Surface(
            color = Charcoal500,
            elevation = 8.dp,
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                if (!pcGames.isNullOrEmpty()) {
                    SubTitleText(title = "PC") {
                        val jsonString = listParamsToJsonString(PC_PARAMS)
                        Timber.d("jsonString[PC]: $jsonString")
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(pcGames, navController, modifier, gameCnt)
                }
                if (!psGames.isNullOrEmpty()) {
                    SubTitleText(title = "PlayStation") {
                        val jsonString = listParamsToJsonString(PS_PARAMS)
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(psGames, navController, modifier, gameCnt)
                }

                if (!xboxGames.isNullOrEmpty()) {
                    SubTitleText(title = "Xbox") {
                        val jsonString = listParamsToJsonString(XBOX_PARAMS)
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(xboxGames, navController, modifier, gameCnt)
                }
                if (!mobileGames.isNullOrEmpty()) {

                    SubTitleText(title = "Mobile") {
                        val jsonString = listParamsToJsonString(MOBILE_PARAMS)
                        navController?.navigate("rank/$jsonString/hide")
                    }
                    HorizontalList(mobileGames, navController, modifier, gameCnt)
                }
            }
        }
    }
}

@Composable
fun TopContent(
    topGames: List<Game>,
    navController: NavHostController?,
    text: String
) {

    MainTitleText(text) {}
    HorizontalGamePager(topGames, navController)


}

@Composable
fun RankGames(
    games: List<Game>,
    navController: NavHostController?
) {
    Surface(
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            games.forEach { game ->
                RankGame(navController, game)
            }
        }
    }
}

@Composable
private fun RankGame(
    navController: NavHostController?,
    game: Game
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 6.dp)
            .clickable(onClick = {
                navController?.navigate("detail/${game.id}/hide")
            })
    ) {
        Row(
            modifier = Modifier
                .background(color = Charcoal200)
        ) {
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
                modifier = Modifier
                    .width(120.dp)
                    .height(80.dp),
                contentDescription = "game picture description",
                contentScale = ContentScale.Crop
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
            val clickAction: () -> Unit = {
                navController?.navigate("detail/${game.id}/hide")
            }
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
            .padding(4.dp)
            .clickable(onClick = { clickAction.invoke() }),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {

        Box(modifier = Modifier.align(Alignment.CenterVertically)) {
            Divider(
                color = Yellow200,
                modifier = Modifier
                    .height(20.dp)
                    .width(2.dp)
            )
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text(
            text = "SEE MORE",
            color = Color.LightGray,
            style = TextStyle(
                fontSize = 10.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
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
        RatingOnCircle(score = game.rating, modifier = Modifier.align(Alignment.TopEnd))
    }

}

@Composable
fun GameDescription(game: Game, modifier: Modifier, style: TextStyle) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AddedText(game.added)
            RatingText(game.rating)
            MetaScoreText(game.metacritic)
        }
        Text(
            text = game.name,
            style = style,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = game.released,
            style = TextStyle(fontSize = 12.sp),
            color = Grey200,
            maxLines = 1
        )
    }
}
/*

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


*/



