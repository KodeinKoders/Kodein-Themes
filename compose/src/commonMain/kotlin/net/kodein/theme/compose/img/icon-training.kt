package net.kodein.theme.compose.img

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import net.kodein.theme.compose.KodeinVectorImages


private val imageVector by lazy {
    Builder(
        name = "Icon-training",
        defaultWidth = 614.33.dp,
        defaultHeight = 475.42.dp,
        viewportWidth = 614.33f,
        viewportHeight = 475.42f
    ).apply {
        path(
            fill = SolidColor(Color(0xFF000000)),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero
        ) {
            moveTo(605.0f, 90.26f)
            curveTo(517.64f, 31.34f, 419.34f, 0.2f, 320.7f, 0.2f)
            horizontalLineToRelative(-9.79f)
            arcToRelative(18.8f, 18.8f, 0.0f, false, false, -5.47f, 0.0f)
            horizontalLineTo(294.22f)
            curveTo(201.81f, 0.2f, 109.05f, 27.73f, 26.0f, 79.82f)
            lineTo(10.0f, 89.88f)
            arcToRelative(21.23f, 21.23f, 0.0f, false, false, 22.56f, 36.0f)
            lineToRelative(16.0f, -10.06f)
            curveToRelative(74.09f, -46.47f, 156.36f, -71.65f, 238.38f, -73.06f)
            verticalLineTo(99.2f)
            curveToRelative(-38.11f, 35.93f, -64.22f, 75.89f, -77.36f, 118.0f)
            horizontalLineTo(53.0f)
            arcToRelative(21.24f, 21.24f, 0.0f, false, false, 0.0f, 42.48f)
            horizontalLineTo(200.82f)
            curveToRelative(-0.72f, 7.0f, -1.12f, 14.11f, -1.15f, 21.22f)
            curveToRelative(-0.18f, 53.62f, 19.74f, 105.44f, 58.0f, 152.0f)
            horizontalLineTo(207.88f)
            arcToRelative(21.24f, 21.24f, 0.0f, true, false, 0.0f, 42.47f)
            horizontalLineTo(407.05f)
            arcToRelative(21.24f, 21.24f, 0.0f, true, false, 0.0f, -42.47f)
            horizontalLineTo(357.62f)
            curveToRelative(38.61f, -46.45f, 58.87f, -98.19f, 59.06f, -151.82f)
            curveToRelative(0.0f, -7.18f, -0.34f, -14.32f, -1.0f, -21.42f)
            horizontalLineTo(558.57f)
            arcToRelative(21.24f, 21.24f, 0.0f, false, false, 0.0f, -42.48f)
            horizontalLineTo(407.15f)
            curveToRelative(-13.0f, -42.51f, -39.2f, -82.89f, -77.74f, -119.29f)
            verticalLineTo(42.76f)
            curveToRelative(87.23f, 1.78f, 174.1f, 30.29f, 251.81f, 82.71f)
            arcTo(21.24f, 21.24f, 0.0f, false, false, 605.0f, 90.26f)
            close()
            moveTo(369.78f, 241.9f)
            arcToRelative(20.71f, 20.71f, 0.0f, false, false, 0.58f, 2.62f)
            arcTo(169.72f, 169.72f, 0.0f, false, true, 374.2f, 281.0f)
            curveToRelative(-0.18f, 50.73f, -23.14f, 100.15f, -66.65f, 143.91f)
            curveToRelative(-43.0f, -43.8f, -65.57f, -93.2f, -65.4f, -143.81f)
            reflectiveCurveToRelative(23.14f, -100.16f, 66.65f, -143.92f)
            curveTo(340.67f, 169.6f, 361.29f, 205.11f, 369.78f, 241.9f)
            close()
        }
    }.build()
}

public val KodeinVectorImages.Icons.Training: ImageVector get() = imageVector
