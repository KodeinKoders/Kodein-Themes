package net.kodein.theme.cup.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinCupVectors.Jetbrains: ImageVector
    get() {
        if (_Jetbrains != null) {
            return _Jetbrains!!
        }
        _Jetbrains = ImageVector.Builder(
            name = "Jetbrains",
            defaultWidth = 70.dp,
            defaultHeight = 70.dp,
            viewportWidth = 70f,
            viewportHeight = 70f,
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd,
            ) {
                moveTo(6.84f, 69.99f)
                horizontalLineToRelative(31.1f)
                curveToRelative(3.91f, 0f, 7.59f, -1.52f, 10.37f, -4.28f)
                lineToRelative(17.4f, -17.4f)
                curveToRelative(2.73f, -2.73f, 4.29f, -6.51f, 4.29f, -10.37f)
                verticalLineTo(6.84f)
                curveToRelative(0f, -3.78f, -3.07f, -6.84f, -6.84f, -6.84f)
                horizontalLineToRelative(-31.11f)
                curveToRelative(-3.9f, 0f, -7.59f, 1.53f, -10.36f, 4.29f)
                lineTo(4.29f, 21.68f)
                curveToRelative(-2.73f, 2.73f, -4.29f, 6.51f, -4.29f, 10.37f)
                verticalLineToRelative(31.1f)
                curveToRelative(0f, 3.78f, 3.07f, 6.84f, 6.84f, 6.84f)
                close()
                moveTo(11.56f, 19f)
                lineToRelative(12.42f, -12.42f)
                curveToRelative(2.17f, -2.16f, 5.03f, -3.34f, 8.07f, -3.34f)
                horizontalLineToRelative(31.11f)
                curveToRelative(1.99f, 0f, 3.6f, 1.62f, 3.6f, 3.6f)
                verticalLineToRelative(31.1f)
                curveToRelative(0f, 3f, -1.21f, 5.94f, -3.34f, 8.07f)
                lineToRelative(-12.42f, 12.42f)
                verticalLineTo(19f)
                horizontalLineTo(11.56f)
                close()
                moveTo(11f, 19.56f)
                verticalLineToRelative(39.44f)
                horizontalLineToRelative(39.43f)
                lineToRelative(-4.41f, 4.41f)
                curveToRelative(-2.16f, 2.15f, -5.03f, 3.34f, -8.07f, 3.34f)
                horizontalLineTo(6.84f)
                curveToRelative(-1.99f, 0f, -3.6f, -1.62f, -3.6f, -3.6f)
                verticalLineToRelative(-31.1f)
                curveToRelative(0f, -3f, 1.21f, -5.94f, 3.34f, -8.07f)
                lineToRelative(4.42f, -4.42f)
                close()
                moveTo(33f, 50f)
                horizontalLineToRelative(-17f)
                verticalLineToRelative(4f)
                horizontalLineToRelative(17f)
                verticalLineToRelative(-4f)
                close()
            }
        }.build()

        return _Jetbrains!!
    }

@Suppress("ObjectPropertyName")
private var _Jetbrains: ImageVector? = null
