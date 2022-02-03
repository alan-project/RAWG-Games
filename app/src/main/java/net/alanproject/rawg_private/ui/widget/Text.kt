package net.alanproject.rawg_private.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.alanproject.rawg_private.R

@Composable
fun RatingText(
    rating: Double
) {
    Image(
        painter = painterResource(R.drawable.ic_rating),
        contentDescription = null,
        modifier = Modifier.size(12.dp)
    )
    Text(
        text = rating.toString(),
        style = TextStyle(color = Color.White, fontSize = 12.sp),
        modifier = Modifier.padding(start = 4.dp),
    )
}

@Composable
fun MetaScoreText(
    metacritic: Int
) {
    Image(
        painter = painterResource(R.drawable.ic_meta_score),
        contentDescription = null,
        modifier = Modifier
            .size(20.dp)
            .padding(start = 8.dp)
    )
    Text(
        text = metacritic.toString(),
        style = TextStyle(color = Color.White, fontSize = 12.sp),
        modifier = Modifier.padding(start = 4.dp)
    )
}