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
        name = "Icon-advisory",
        defaultWidth = 662.44.dp,
        defaultHeight = 480.1.dp,
        viewportWidth = 662.44f,
        viewportHeight = 480.1f
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
            moveTo(609.55f, 12.0f)
            arcToRelative(21.24f, 21.24f, 0.0f, false, false, -38.27f, 18.43f)
            lineToRelative(5.91f, 12.27f)
            arcTo(434.87f, 434.87f, 0.0f, false, true, 619.07f, 202.8f)
            lineTo(422.31f, 66.0f)
            arcToRelative(21.24f, 21.24f, 0.0f, true, false, -24.24f, 34.88f)
            lineTo(567.68f, 218.81f)
            horizontalLineTo(93.07f)
            lineTo(264.29f, 101.0f)
            arcTo(21.24f, 21.24f, 0.0f, false, false, 240.2f, 66.0f)
            lineTo(43.42f, 201.42f)
            arcTo(434.2f, 434.2f, 0.0f, false, true, 90.87f, 31.0f)
            arcTo(21.24f, 21.24f, 0.0f, true, false, 53.15f, 11.48f)
            arcTo(476.53f, 476.53f, 0.0f, false, false, 0.0f, 229.69f)
            verticalLineTo(250.0f)
            arcTo(477.25f, 477.25f, 0.0f, false, false, 47.0f, 455.79f)
            lineToRelative(5.91f, 12.27f)
            arcToRelative(21.23f, 21.23f, 0.0f, true, false, 38.27f, -18.41f)
            lineToRelative(-5.91f, -12.28f)
            arcToRelative(435.0f, 435.0f, 0.0f, false, true, -42.0f, -161.69f)
            lineTo(240.12f, 412.52f)
            arcToRelative(21.24f, 21.24f, 0.0f, false, false, 24.25f, -34.88f)
            lineTo(97.0f, 261.28f)
            horizontalLineTo(567.13f)
            lineToRelative(-169.0f, 116.31f)
            arcToRelative(21.23f, 21.23f, 0.0f, true, false, 24.08f, 35.0f)
            lineTo(619.12f, 277.06f)
            arcToRelative(434.0f, 434.0f, 0.0f, false, true, -47.56f, 172.0f)
            arcToRelative(21.24f, 21.24f, 0.0f, true, false, 37.72f, 19.53f)
            arcTo(476.49f, 476.49f, 0.0f, false, false, 662.44f, 250.4f)
            verticalLineTo(230.14f)
            arcToRelative(477.37f, 477.37f, 0.0f, false, false, -47.0f, -205.84f)
            close()
        }
    }.build()
}

public val KodeinVectorImages.Icons.Advisory: ImageVector get() = imageVector
