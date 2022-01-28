package net.alanproject.rawg_private.ui.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import net.alanproject.domain.model.list.Result

@Composable
fun ListScreen(navController1: Int, navController: NavHostController?) {
    val viewModel = hiltViewModel<ListViewModel>()
    val list = viewModel.listState.value

    Scaffold(topBar = {
        AppBar(
            title = "Game List",
            icon = Icons.Default.Home
        ) {
            //do nothing
        }
    }) {
        //background
        Surface(
            // color, parameter of Surface is set as Material Theme.color.surface by default
            // so that color is derived from veryLightGrey in Theme.kt
            // and need to be careful as colors in Theme.kt is called in many places
//            color = MaterialTheme.colors.black,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                //'items' iterate actual items
                items(list) { result ->
                    ProfileCard(result,{})
                }
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
fun ProfileCard(game: Result, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = { clickAction.invoke() }),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(game.backgroundImage, 72.dp)
            ProfileContent(game.name, Alignment.Start)
        }

    }
}

@Composable
fun ProfilePicture(pictureUrl: String, imageSize: Dp) {
    //by wrapping Image with Card, we can use shape, border, elevation parameter
    Card(
        shape = RoundedCornerShape(10),
        modifier = Modifier.padding(16.dp)
            .width(100.dp),
        elevation = 4.dp
    ) {

        Image(
            //loaded asynchronously
            painter = rememberImagePainter(
                data = pictureUrl
            ),
            modifier = Modifier.size(imageSize),
            contentDescription = "Profile picture description",
        )
    }
}

@Composable
fun ProfileContent(userName: String, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment

    ) {
        //transparency

            Text(
                text = userName,
                style = MaterialTheme.typography.h5
            )

    }

}