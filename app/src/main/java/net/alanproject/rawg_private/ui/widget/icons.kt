package net.alanproject.rawg_private.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.alanproject.domain.model.response.Game
import net.alanproject.rawg_private.R
import timber.log.Timber

@Composable
fun Icons(game: Game) {

    val platformSet = mutableSetOf<Int>()
    Timber.d("Icons: $game")


    game.platforms.forEach { eachPlatform ->
        val platformId = eachPlatform.platform.id
        Timber.d("platformId: $platformId")
        when (platformId) {

            4, 5 -> platformSet.add(PC)
            6 -> platformSet.add(LINUX)
            15, 16, 18, 187, 27, 19, 17 -> platformSet.add(PS)
            1, 14, 80, 186 -> platformSet.add(XBOX)
            83, 7, 8, 9, 13, 10, 11 -> platformSet.add(NINTENDO)
            3 -> platformSet.add(IOS)
            21 -> platformSet.add(ANDROID)
            else -> {}
        }

    }
    DrawIcon(platformSet)
}

@Composable
fun DrawIcon(platformSet: MutableSet<Int>) {
    Timber.d("platform: $platformSet")
    Row(modifier = Modifier.padding(top=8.dp)) {

        platformSet.forEach { platformId ->
            Image(
                painterResource(platformId),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(12.dp)
                    .width(16.dp)
                    .padding(end = 4.dp)
            )
        }
    }
}

const val PC = R.drawable.ic_pc
const val LINUX = R.drawable.ic_linux
const val PS = R.drawable.ic_ps
const val XBOX = R.drawable.ic_xbox
const val NINTENDO = R.drawable.ic_nintendo
const val ANDROID = R.drawable.ic_android
const val IOS = R.drawable.ic_ios


