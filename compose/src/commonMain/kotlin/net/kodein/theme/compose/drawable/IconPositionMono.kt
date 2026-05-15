package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconPositionMono: ImageVector
    get() {
        if (_IconPositionMono != null) {
            return _IconPositionMono!!
        }
        _IconPositionMono = ImageVector.Builder(
            name = "IconPositionMono",
            defaultWidth = 86.dp,
            defaultHeight = 69.dp,
            viewportWidth = 86f,
            viewportHeight = 69f,
        ).apply {
            path(
                stroke = SolidColor(Color(0xFFE84420)),
                strokeLineWidth = 4.2488f,
            ) {
                moveTo(28.628f, 39.516f)
                moveToRelative(-26.503f, 0f)
                arcToRelative(26.503f, 26.503f, 0f, isMoreThanHalf = true, isPositiveArc = true, 53.005f, 0f)
                arcToRelative(26.503f, 26.503f, 0f, isMoreThanHalf = true, isPositiveArc = true, -53.005f, 0f)
            }
            path(
                fill = SolidColor(Color(0xFFF0A698)),
                pathFillType = PathFillType.EvenOdd,
            ) {
                moveTo(64.648f, 0.518f)
                curveTo(65.039f, 0.127f, 65.568f, -0.043f, 66.079f, 0.009f)
                curveTo(66.105f, 0.007f, 66.13f, 0.006f, 66.156f, 0.006f)
                horizontalLineTo(84.441f)
                curveTo(85.404f, 0.006f, 85.87f, 1.184f, 85.168f, 1.843f)
                lineTo(75.458f, 10.956f)
                curveTo(75.261f, 11.141f, 75f, 11.243f, 74.73f, 11.243f)
                horizontalLineTo(58.931f)
                lineTo(29.88f, 40.294f)
                curveTo(29.188f, 40.986f, 28.067f, 40.986f, 27.376f, 40.294f)
                curveTo(26.685f, 39.603f, 26.685f, 38.482f, 27.376f, 37.79f)
                lineTo(64.648f, 0.518f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFE84420)),
                strokeLineWidth = 3.54067f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(62.413f, 18.546f)
                lineTo(82.851f, 18.546f)
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(28.628f, 39.516f)
                moveToRelative(6.931f, 0f)
                arcToRelative(6.931f, 6.931f, 0f, isMoreThanHalf = true, isPositiveArc = false, -13.862f, 0f)
                arcToRelative(6.931f, 6.931f, 0f, isMoreThanHalf = true, isPositiveArc = false, 13.862f, 0f)
            }
        }.build()

        return _IconPositionMono!!
    }

@Suppress("ObjectPropertyName")
private var _IconPositionMono: ImageVector? = null
