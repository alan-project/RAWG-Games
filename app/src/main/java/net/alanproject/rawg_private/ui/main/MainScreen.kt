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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import net.alanproject.domain.model.params.ListParams
import net.alanproject.domain.model.params.listParamsToJsonString
import net.alanproject.domain.model.response.list.Game
import net.alanproject.rawg_private.R
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

    //New $ Trending
    val trendingGames by remember { viewModel.trendingGamesState }

    //What's Hot Now
    val upcomingGames by remember { viewModel.upcomingGamesState }
    val releaseGames by remember { viewModel.releaseGamesState }

    //Ranking
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
            //Trending Games
            if (!trendingGames.isNullOrEmpty()) {
                TrendingGames(
                    trendingGames,
                    navController,
                    text = stringResource(R.string.main_title_trending)
                )
            }

            //Hot Games
            if (!releaseGames.isNullOrEmpty()
                || !upcomingGames.isNullOrEmpty()
            ) {
                MainTitleText(title = stringResource(R.string.main_title_hot)) {}
                Surface(
                    color = Charcoal500,
                    elevation = 8.dp,
                ) {
                    Column {
                        HorizontalListWithTitle(
                            games = releaseGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_release),
                            params = RELEASE_PARAMS,
                            gameCnt = 20
                        )
                        HorizontalListWithTitle(
                            games = upcomingGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_upcoming),
                            params = UPCOMING_PARAMS,
                            gameCnt = 20
                        )
                    }
                }
            }


            //Total Rankings
            if (!totalRankGames.isNullOrEmpty()) {
                Ranking(
                    totalRankGames,
                    navController,
                    text = stringResource(R.string.main_title_rank)
                )
            }

            //By Generes
            if (!actionGames.isNullOrEmpty()
                || !strategyGames.isNullOrEmpty()
                || !puzzleGames.isNullOrEmpty()
                || !racingGames.isNullOrEmpty()
            ) {
                MainTitleText(title = stringResource(R.string.main_title_bygenres)) {}
                Surface(
                    color = Charcoal500,
                    elevation = 8.dp,
                ) {
                    Column {
                        HorizontalListWithTitle(
                            games = actionGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_action),
                            params = ACTION_PARAMS,
                            gameCnt = 20
                        )
                        HorizontalListWithTitle(
                            games = strategyGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_strategy),
                            params = STRATEGY_PARAMS,
                            gameCnt = 20
                        )
                        HorizontalListWithTitle(
                            games = puzzleGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_puzzle),
                            params = PUZZLE_PARAMS,
                            gameCnt = 20
                        )
                        HorizontalListWithTitle(
                            games = racingGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_racing),
                            params = RACING_PARAMS,
                            gameCnt = 20
                        )
                    }
                }
            }

            //By Consoles
            if (!pcGames.isNullOrEmpty()
                || !psGames.isNullOrEmpty()
                || !xboxGames.isNullOrEmpty()
                || !mobileGames.isNullOrEmpty()
            ) {
                MainTitleText(title = stringResource(R.string.main_title_byconsoles)) {}
                Surface(
                    color = Charcoal500,
                    elevation = 8.dp,
                ) {
                    Column {
                        HorizontalListWithTitle(
                            games = pcGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_pc),
                            params = PC_PARAMS,
                            gameCnt = 20
                        )
                        HorizontalListWithTitle(
                            games = psGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_playstation),
                            params = PS_PARAMS,
                            gameCnt = 20
                        )
                        HorizontalListWithTitle(
                            games = xboxGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_xbox),
                            params = XBOX_PARAMS,
                            gameCnt = 20
                        )
                        HorizontalListWithTitle(
                            games = mobileGames,
                            navController = navController,
                            subTitle = stringResource(R.string.sub_title_mobile),
                            params = MOBILE_PARAMS,
                            gameCnt = 20
                        )
                    }
                }
            }
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
        MainTitleText(text) { }
        Surface(
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                rankGames.forEach { game ->
                    RankGame(navController, game)
                }
            }
        }
    }
}


@Composable
private fun HorizontalListWithTitle(
    games: List<Game>?,
    navController: NavHostController?,
    subTitle: String,
    params: ListParams,
    gameCnt: Int

) {
    val modifier = Modifier
        .width(240.dp)
        .wrapContentHeight()
        .padding(4.dp)

    if (!games.isNullOrEmpty()) {

        SubTitleText(title = subTitle) {

            val jsonString = listParamsToJsonString(params)
            navController?.navigate("rank/$jsonString/hide")
        }
        HorizontalList(games, navController, modifier, gameCnt)
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
        modifier = Modifier.padding(top = 24.dp, bottom = 24.dp,start = 8.dp)
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
            text = stringResource(R.string.see_more),
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


