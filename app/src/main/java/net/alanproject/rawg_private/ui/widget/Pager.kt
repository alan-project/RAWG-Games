package net.alanproject.rawg_private.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import net.alanproject.domain.model.response.list.Game
import net.alanproject.rawg_private.ui.main.GameScreenWithText
import net.alanproject.rawg_private.ui.theme.Charcoal500

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalGamePager(
    games: List<Game>,
    navController: NavHostController?
) {
    val maxCntNum = if(games.size <5 ) games.size else 5

    val pagerState = rememberPagerState()
    LaunchedEffect(pagerState.currentPage) {
        delay(3000) // wait for 3 seconds.
        // increasing the position and check the limit
        val newPosition = pagerState.currentPage + 1
        // scrolling to the new position.
        pagerState.animateScrollToPage(newPosition)
    }

    HorizontalPager(count = Int.MAX_VALUE, state = pagerState) { cnt ->
        val count = cnt % maxCntNum
        Surface(
            color = Charcoal500,
            elevation = 8.dp,

            ) {

            val clickAction: () -> Unit =
                { navController?.navigate("detail/${games[count].id}") }
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
                    games[count], modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }
    }
}