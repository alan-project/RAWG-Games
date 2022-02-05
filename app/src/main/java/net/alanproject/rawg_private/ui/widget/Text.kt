package net.alanproject.rawg_private.ui.widget

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.alanproject.rawg_private.R

@Composable
fun AddedText(
    added: Int
) {
    if (added != 0) {
        Image(
            painter = painterResource(R.drawable.ic_added),
            contentDescription = null,
            modifier = Modifier.size(9.dp)
        )
        Text(
            text = added.toString(),
            style = TextStyle(color = Color.White, fontSize = 12.sp),
            modifier = Modifier.padding(start = 3.dp),
        )
    }
}


@Composable
fun RatingText(
    rating: Double
) {
    if (rating != 0.0) {
        Image(
            painter = painterResource(R.drawable.ic_rating),
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = rating.toString(),
            style = TextStyle(color = Color.White, fontSize = 12.sp),
            modifier = Modifier.padding(start = 4.dp),
        )
    }

}

@Composable
fun MetaScoreText(
    metaScore: Int
) {
    if (metaScore != 0) {
        Image(
            painter = painterResource(R.drawable.ic_meta_score),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = metaScore.toString(),
            style = TextStyle(color = Color.White, fontSize = 12.sp),
            modifier = Modifier.padding(start = 4.dp)
        )
    }

}

@Composable
fun ExpandableText(
    text: String,
    ) {

    var showMore by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(start = 20.dp, end=20.dp)) {
        Column(modifier = Modifier
            .animateContentSize(animationSpec = tween(100))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { showMore = !showMore }) {

            if (showMore) {
                Column() {
                    Text(
                        text = text,
                        color = Color.White
                    )

                    Card(
                        shape = RoundedCornerShape(20),
                        modifier = Modifier
                            .wrapContentSize()
                            .align(alignment = Alignment.End),
                        elevation = 4.dp,
                        backgroundColor = Color.LightGray
                    ) {
                        Text(
                            text = "LESS",
                            color = Color.Black,
                            fontSize = 8.sp,
                            modifier = Modifier.padding(start=2.dp, end=2.dp)
                        )
                    }
                }

            } else {
                Column() {
                    Text(
                        text = text,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
                    )
                    Card(
                        shape = RoundedCornerShape(20),
                        modifier = Modifier
                            .wrapContentSize()
                            .align(alignment = Alignment.End),
                        elevation = 4.dp,
                        backgroundColor = Color.LightGray
                    ) {
                        Text(
                            text = "MORE",
                            color = Color.Black,
                            fontSize = 8.sp,
                            modifier = Modifier.padding(start=2.dp, end=2.dp)
                        )
                    }
                }

            }
        }
    }
}