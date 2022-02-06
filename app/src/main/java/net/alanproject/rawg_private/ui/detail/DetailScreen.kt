package net.alanproject.rawg_private.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import net.alanproject.domain.model.response.custom.Specification
import net.alanproject.domain.model.response.custom.mapToSpecification
import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.rawg_private.common.RetrySection
import net.alanproject.rawg_private.ui.theme.Yellow200
import net.alanproject.rawg_private.ui.widget.ExpandableText
import net.alanproject.rawg_private.ui.widget.Icons2
import net.alanproject.rawg_private.ui.widget.grayScaleMatrix
import timber.log.Timber

@Composable
fun DetailScreen(gameId: Int, navController: NavHostController?) {
    val viewModel = hiltViewModel<DetailViewModel>().apply {
        onLoadGame(gameId)
    }
    val game by remember { viewModel.gameState }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }

    Scaffold(topBar = {
        AppBar(
            title = "Users profile details",
            icon = Icons.Default.ArrowBack
        ) {
            //pop most current composable
            navController?.navigateUp()
        }
    }) {
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
    Column() {
        val twoColumnModifier = Modifier
            .padding(top = 20.dp, start = 20.dp)
            .width(180.dp)

        Row(modifier = Modifier.padding(top = 8.dp)) {
            VerticalColumn("Platforms", spec.platforms, modifier = twoColumnModifier)
            VerticalColumn("Genre", spec.genres, modifier = twoColumnModifier)
        }
        Row(modifier = Modifier.padding(top = 8.dp)) {
            VerticalColumn("Release date", spec.releaseDate, modifier = twoColumnModifier)
            VerticalColumn("Developer", spec.developer, modifier = twoColumnModifier)
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            VerticalColumn("Publisher", spec.publisher, modifier = twoColumnModifier)
            VerticalColumn("Age rating", spec.ageRating, modifier = twoColumnModifier)
        }

        VerticalColumn(
            title = "Tags",
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
    Column() {
        Text(
            text = "About",
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
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier.fillMaxSize()
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 16.dp, top = 8.dp, end = 8.dp),
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
                Icons2(game)
            }


            Text(
                text = game.nameOriginal,
                style = TextStyle(
                    color = Color.White, fontSize = 32.sp,
                    fontWeight = ExtraBold
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .width(300.dp)
                    .padding(top = 8.dp)
            )

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TopContent() {

}


@Composable
fun AppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = { iconClickAction.invoke() })
            )
        },
        title = { Text(title) }
    )
}