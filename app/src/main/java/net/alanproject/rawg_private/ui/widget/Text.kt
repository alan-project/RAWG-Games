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
fun AddedText(
    added: Int
) {
    if(added!=0){
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
    if(rating!=0.0){
        Image(
            painter = painterResource(R.drawable.ic_rating),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
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
    if(metaScore!=0){
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