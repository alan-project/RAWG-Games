package net.alanproject.rawg_private.ui.widget

import androidx.compose.ui.graphics.ColorMatrix

val grayScaleMatrix = ColorMatrix(
    floatArrayOf(
        0.11f, 0.11f, 0.11f, 0f, 0f,
        0.11f, 0.11f, 0.11f, 0f, 0f,
        0.11f, 0.11f, 0.11f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
)