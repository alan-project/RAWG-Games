package net.alanproject.rawg_private.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation

@Composable
fun DetailScreen(id: Int, navController: NavHostController?) {
    val viewModel = hiltViewModel<DetailViewModel>()
    val game = viewModel.gameState.value

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
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // reuse and customize composable
                ProfilePicture(game.backgroundImage, 240.dp)
                ProfileContent(game.name, Alignment.CenterHorizontally)
            }
        }
    }
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


@Composable
fun ProfilePicture(pictureUrl: String, imageSize: Dp) {
    //by wrapping Image with Card, we can use shape, border, elevation parameter
    Card(
        shape = RoundedCornerShape(10),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {

        Image(
            //loaded asynchronously
            painter = rememberImagePainter(
                data = pictureUrl,
                builder = {
                    transformations(RoundedCornersTransformation())
                }
            ),
            modifier = Modifier.size(imageSize),
            contentDescription = "Profile picture description",
        )
    }
}

@Composable
fun ProfileContent(gameName: String, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment

    ) {

        Text(
            text = gameName,
            style = MaterialTheme.typography.h5
        )

    }

}