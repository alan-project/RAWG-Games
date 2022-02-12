package net.alanproject.rawg_private.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import net.alanproject.domain.model.response.custom.Specification
import net.alanproject.domain.model.response.custom.mapToSpecification
import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.model.response.detail.mapToEachPlatform
import net.alanproject.domain.model.response.screenshots.Screenshots
import net.alanproject.rawg_private.R
import net.alanproject.rawg_private.common.RetrySection
import net.alanproject.rawg_private.ui.theme.Charcoal500
import net.alanproject.rawg_private.ui.theme.Yellow200
import net.alanproject.rawg_private.ui.widget.*
import timber.log.Timber

@Composable
fun DetailScreen(gameId: Int, navController: NavHostController?) {
    val viewModel = hiltViewModel<DetailViewModel>().apply {
        onLoadGame(gameId)
    }
    val game: GameDetail by remember { viewModel.gameState }
    val gameScreenShots: Screenshots by remember { viewModel.screenshotsState }

    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }

    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                TopContent(game)

                About(game.descriptionRaw)
                HorizontalThumbnailPager(gameScreenShots)
                Specification(game)


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
                        viewModel.onLoadGame(gameId)
                    }
                }
            }
        }
    }
}

@Composable
fun Specification(game: GameDetail) {

    val spec: Specification = mapToSpecification(game)
    Column {
        val twoColumnModifier = Modifier
            .padding(top = 20.dp, start = 20.dp)
            .width(180.dp)

        Row(modifier = Modifier.padding(top = 8.dp)) {
            VerticalColumn(
                stringResource(R.string.detail_platforms),
                spec.platforms,
                modifier = twoColumnModifier
            )
            VerticalColumn(
                stringResource(R.string.detail_genre),
                spec.genres,
                modifier = twoColumnModifier
            )
        }
        Row(modifier = Modifier.padding(top = 8.dp)) {
            VerticalColumn(
                stringResource(R.string.detail_release_date),
                spec.releaseDate,
                modifier = twoColumnModifier
            )
            VerticalColumn(
                stringResource(R.string.detail_developer),
                spec.developer,
                modifier = twoColumnModifier
            )
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            VerticalColumn(
                stringResource(R.string.detail_publisher),
                spec.publisher,
                modifier = twoColumnModifier
            )
            VerticalColumn(
                stringResource(R.string.detail_age_rating),
                spec.ageRating,
                modifier = twoColumnModifier
            )
        }

        VerticalColumn(
            title = stringResource(R.string.detail_tags),
            items = spec.tags,
            modifier = Modifier.padding(20.dp)
        )
    }

}

@Composable
fun VerticalColumn(title: String, items: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Text(text = title, style = TextStyle(color = Color.Gray), fontSize = 16.sp)
        Text(text = items, maxLines = 4, style = TextStyle(color = Color.White), fontSize = 12.sp)
    }
}

@Composable
fun About(description: String) {
    Timber.d("description: $description")
    Column {
        Text(
            text = stringResource(R.string.detail_title_about),
            style = TextStyle(color = Color.White, fontWeight = Bold, fontSize = 24.sp),
            modifier = Modifier.padding(start = 20.dp, top = 8.dp, bottom = 8.dp)
        )
        ExpandableText(
            text = description,
        )
    }
}

@Composable
fun TopContent(game: GameDetail, modifier: Modifier = Modifier) {
    //by wrapping Image with Card, we can use shape, border, elevation parameter
    Card(
        shape = RoundedCornerShape(10),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp),
        elevation = 4.dp
    ) {

        Image(
            //loaded asynchronously
            painter = rememberImagePainter(
                data = game.backgroundImage,
                builder = {
                    transformations(RoundedCornersTransformation())
                }
            ),
            modifier = modifier.fillMaxWidth(),
            contentDescription = "Game Thumbnail description",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(grayScaleMatrix)
        )
        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {


            Row(verticalAlignment = Alignment.CenterVertically) {
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 8.dp, end = 8.dp),
                    backgroundColor = Color.White

                ) {
                    Text(

                        text = game.released,
                        style = TextStyle(
                            color = Color.Black, fontSize = 12.sp,
                            fontWeight = Bold
                        ),
                        modifier = Modifier
                            .padding(1.dp)
                    )
                }

                Icons(game.platforms.map {
                    it.mapToEachPlatform()
                })
            }

            Text(
                text = game.nameOriginal,
                style = TextStyle(
                    color = Color.White, fontSize = 32.sp,
                    fontWeight = ExtraBold
                ),
                modifier = Modifier
                    .width(300.dp)
                    .padding(top = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 4.dp)
            ) {
                AddedText(game.added)
                RatingText(game.rating)
                MetaScoreText(game.metacritic)

            }

        }


    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalThumbnailPager(
    screenshots: Screenshots
) {
    if (!screenshots.results.isNullOrEmpty() && screenshots.count != 0) {
        Column {
            Text(
                text = stringResource(R.string.detail_title_screenshota),
                style = TextStyle(color = Color.White, fontWeight = Bold, fontSize = 24.sp),
                modifier = Modifier.padding(start = 20.dp, top = 8.dp, bottom = 8.dp)
            )
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            ) {
                val maxCntNum = screenshots.count
                Timber.d("screenshots.results.size: $maxCntNum")

/*                val pagerState = rememberPagerState()
                LaunchedEffect(pagerState.currentPage) {
                    delay(3000) // wait for 3 seconds.
                    // increasing the position and check the limit
                    val newPosition = pagerState.currentPage + 1
                    // scrolling to the new position.
                    pagerState.animateScrollToPage(newPosition)
                }*/


                HorizontalPager(
                    count = Int.MAX_VALUE,
                    /*state = pagerState,*/
                    contentPadding = PaddingValues(end = 64.dp),
                ) { cnt ->


                    val count = cnt % maxCntNum!!
                    Surface(
                        color = Charcoal500,
                        elevation = 8.dp,

                        ) {

                        Card(
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(align = Alignment.Top)
                                .padding(8.dp),
                            elevation = 8.dp,
                            backgroundColor = Color.White
                        ) {

                            Image(
                                //loaded asynchronously
                                painter = rememberImagePainter(
                                    data = screenshots.results!![count].image,
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

                        }
                    }
                }
            }
        }
    }


}

