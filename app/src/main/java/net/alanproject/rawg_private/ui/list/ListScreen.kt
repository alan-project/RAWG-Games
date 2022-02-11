package net.alanproject.rawg_private.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import net.alanproject.domain.model.params.ListParams
import net.alanproject.domain.model.response.list.Game
import net.alanproject.rawg_private.R
import net.alanproject.rawg_private.common.Constants.Companion.DEFAULT_PARAMS
import net.alanproject.rawg_private.common.RetrySection
import net.alanproject.rawg_private.ui.theme.Charcoal500
import net.alanproject.rawg_private.ui.theme.Grey200
import net.alanproject.rawg_private.ui.theme.Yellow200
import net.alanproject.rawg_private.ui.widget.AddedText
import net.alanproject.rawg_private.ui.widget.Icons
import net.alanproject.rawg_private.ui.widget.MetaScoreText
import net.alanproject.rawg_private.ui.widget.RatingText
import timber.log.Timber

@Composable
fun ListScreen(listParams: ListParams = DEFAULT_PARAMS, navController: NavHostController?) {
    Timber.d("[LoadingError] ListScreen is called")
    Timber.d("listParams: $listParams")
    val viewModel = hiltViewModel<ListViewModel>()

    LaunchedEffect(key1 = true) {
        viewModel.onLoadGames(listParams)
    }


    val games by remember { viewModel.gamesState }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }

    Scaffold {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()

        ) {
            Column() {
                //Title Start
                if (listParams.isFromMain) {
                    RankTitle(listParams)
                }

                //List Start
                LazyColumn {
                    val itemCount = games.size


                    items(itemCount) { it ->

                        //List via MainScreen will show only 20 items(No pagination)
                        if (!listParams.isFromMain) {
                            if (it >= itemCount - 1 && !endReached && !isLoading) {

                                LaunchedEffect(key1 = true) {
                                    Timber.d("[LoadingError] onLoadGames in LaunchedEffect")
                                    viewModel.onLoadGames(listParams)
                                }
                            }
                        }
                        GamesRow(rowIndex = it, games, navController)
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
                        viewModel.onLoadGames(listParams)
                    }
                }
            }
        }
    }
}

@Composable
fun RankTitle(listParams: ListParams) {
    Card(
        shape = RoundedCornerShape(10),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(100.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(start= 16.dp)) {
            Text(
                text = listParams.mainTitle.orEmpty(),
                style = TextStyle(color = Yellow200, fontSize = 16.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            Text(
                text = listParams.subTitle.orEmpty(),
                style = TextStyle(color = Color.White, fontSize = 14.sp),
                modifier = Modifier.padding(bottom = 8.dp, end = 8.dp)
            )
        }
    }

}

@Composable
fun GamesRow(rowIndex: Int, games: List<Game>, navController: NavHostController?) {
    val game = games[rowIndex]
    GameItem(game) {
        navController?.navigate("detail/${game.id}/hide")
    }
}

@Composable
fun GameItem(game: Game, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 6.dp)
            .fillMaxWidth()
            .height(100.dp)
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = { clickAction.invoke() }),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Charcoal500
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            GameThumbnail(
                game.backgroundImage, modifier = Modifier
                    .width(160.dp)
                    .fillMaxHeight()
            )
            GameDescription(
                game,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp),
                style = TextStyle(color = Color.White, fontSize = 16.sp),
            )
        }

    }
}

@Composable
fun GameThumbnail(pictureUrl: String?, modifier: Modifier) {


    Image(
        painter = rememberImagePainter(
            data = pictureUrl
        ),
        modifier = modifier,
        contentDescription = "game picture description",
        contentScale = ContentScale.Crop
    )

}


@Composable
fun GameDescription(game: Game, modifier: Modifier, style: TextStyle) {

    val painterRating = rememberImagePainter(R.drawable.ic_rating)
    val painterMeta = rememberImagePainter(R.drawable.ic_meta_score)
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
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
//            modifier = modifier,
            maxLines = 1, overflow = TextOverflow.Ellipsis
        )
        Text(
            text = game.released,
            style = TextStyle(fontSize = 12.sp),
            color = Grey200,
//            modifier = modifier,
            maxLines = 1
        )
        Icons(game)
    }

}