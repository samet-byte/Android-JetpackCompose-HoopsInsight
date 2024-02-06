package com.sametb.hoopsinsight.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.ui.theme.StarColor


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.components
* Created by SAMET BAYAT 
* on 3.02.2024 at 3:12 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun RatingStarPartiallyFillable(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float,
    modifierSize: Float = 24f,
    starPercentageMultiplier: Float = 0.5f
) {
    Canvas(modifier = Modifier.size(modifierSize.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = starPath,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = starPath) {
                    drawRect(
                        color = StarColor,
                        size = Size(
                            width =  (starPathBounds.maxDimension * 2 * starPercentageMultiplier ) / 1.7f,
                            height = (starPathBounds.maxDimension) * scaleFactor
                        )
                    )
                }
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun PartiallyFilledStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    RatingStarPartiallyFillable(
        starPath = starPath,
        starPathBounds = starPathBounds,
        scaleFactor = 2.8f,
        modifierSize = 24f,
        starPercentageMultiplier = 0.3f
    )
}
