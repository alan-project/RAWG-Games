package net.alanproject.rawg_private.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingOnCircle(score: Double, modifier:Modifier) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        color = Color.Black.copy(alpha = 0.5f),
        modifier = modifier
            .width(44.dp)
            .wrapContentHeight()
            .padding(top = 8.dp, end=8.dp)
    ) {
        Text(
            text = score.toString(),
            modifier =Modifier.padding(4.dp),
            style = TextStyle(textAlign = TextAlign.Center, color = Color.White, fontSize = 12.sp )
        )
    }
}

