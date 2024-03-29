package net.kodein.theme.cup.img

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import net.kodein.theme.compose.KodeinVectorImages


private val imageVector by lazy {
    Builder(
        name = "Kotlin", defaultWidth = 64.0.dp, defaultHeight = 64.0.dp, viewportWidth = 64.0f, viewportHeight = 64.0f
    ).apply {
        path(
            fill = radialGradient(
                0.003435144f to Color(0xFFE44857),
                0.4689f to Color(0xFFC711E1),
                1.0f to Color(0xFF7F52FF),
                center = Offset(61.880184f, 2.6257536f),
                radius = 73.319565f
            ),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero
        ) {
            moveTo(64.0f, 64.0f)
            lineToRelative(-64.0f, 0.0f)
            lineToRelative(0.0f, -64.0f)
            lineToRelative(64.0f, 0.0f)
            lineToRelative(-32.66f, 31.53f)
            close()
        }
    }.build()
}

public val KodeinVectorImages.Logo.KotlinMonogram: ImageVector get() = imageVector
