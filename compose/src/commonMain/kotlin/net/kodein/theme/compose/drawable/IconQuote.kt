package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconQuote: ImageVector
    get() {
        if (_IconQuote != null) {
            return _IconQuote!!
        }
        _IconQuote = ImageVector.Builder(
            name = "IconQuote",
            defaultWidth = 93.dp,
            defaultHeight = 55.dp,
            viewportWidth = 93f,
            viewportHeight = 55f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFFE84420)),
                pathFillType = PathFillType.EvenOdd,
            ) {
                moveTo(84.81f, 0.617f)
                curveTo(74.72f, -1.615f, 65.073f, 2.418f, 58.507f, 9.382f)
                curveTo(51.947f, 16.34f, 47.324f, 25.308f, 49.419f, 36.164f)
                curveTo(51.513f, 47.021f, 59.444f, 54.556f, 71.349f, 54.556f)
                curveTo(82.881f, 54.556f, 92.547f, 45.837f, 92.547f, 34.704f)
                curveTo(92.547f, 23.571f, 82.881f, 14.851f, 71.349f, 14.85f)
                curveTo(71.155f, 14.85f, 70.961f, 14.852f, 70.769f, 14.857f)
                curveTo(71.31f, 13.687f, 72.121f, 12.523f, 73.289f, 11.389f)
                curveTo(75.533f, 9.215f, 79.181f, 7.074f, 84.977f, 5.352f)
                curveTo(86.046f, 5.035f, 86.766f, 4.034f, 86.726f, 2.919f)
                curveTo(86.687f, 1.805f, 85.898f, 0.858f, 84.81f, 0.617f)
                close()
                moveTo(67.326f, 7.993f)
                curveTo(66.404f, 8.659f, 64.071f, 10.169f, 61.737f, 12.646f)
                curveTo(56.605f, 18.089f, 53.031f, 25.865f, 54.722f, 34.704f)
                curveTo(56.413f, 43.543f, 62.069f, 49.661f, 71.349f, 49.661f)
                curveTo(79.674f, 49.661f, 87.652f, 42.796f, 87.652f, 34.704f)
                curveTo(87.652f, 26.611f, 80.527f, 19.746f, 71.349f, 19.745f)
                curveTo(70.179f, 19.745f, 69.038f, 19.859f, 67.939f, 20.073f)
                curveTo(67.173f, 20.223f, 66.381f, 19.998f, 65.808f, 19.468f)
                curveTo(65.236f, 18.938f, 64.949f, 18.166f, 65.039f, 17.39f)
                curveTo(65.42f, 14.101f, 66.876f, 12.149f, 69.901f, 9.216f)
                curveTo(69.579f, 8.294f, 68.249f, 7.328f, 67.326f, 7.993f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFE84420)),
                pathFillType = PathFillType.EvenOdd,
            ) {
                moveTo(35.9f, 0.617f)
                curveTo(25.811f, -1.615f, 16.163f, 2.418f, 9.598f, 9.382f)
                curveTo(3.038f, 16.34f, -1.585f, 25.308f, 0.51f, 36.164f)
                curveTo(2.604f, 47.021f, 10.535f, 54.556f, 22.439f, 54.556f)
                curveTo(33.972f, 54.556f, 43.638f, 45.837f, 43.638f, 34.704f)
                curveTo(43.638f, 23.571f, 33.972f, 14.851f, 22.439f, 14.85f)
                curveTo(22.246f, 14.85f, 22.052f, 14.852f, 21.859f, 14.857f)
                curveTo(22.401f, 13.687f, 23.212f, 12.523f, 24.38f, 11.389f)
                curveTo(26.623f, 9.215f, 30.272f, 7.074f, 36.068f, 5.352f)
                curveTo(37.137f, 5.035f, 37.857f, 4.034f, 37.817f, 2.919f)
                curveTo(37.777f, 1.805f, 36.989f, 0.858f, 35.9f, 0.617f)
                close()
                moveTo(18.417f, 7.993f)
                curveTo(17.495f, 8.659f, 15.162f, 10.169f, 12.828f, 12.646f)
                curveTo(7.696f, 18.089f, 4.122f, 25.865f, 5.813f, 34.704f)
                curveTo(7.504f, 43.543f, 13.16f, 49.661f, 22.439f, 49.661f)
                curveTo(30.764f, 49.661f, 38.743f, 42.796f, 38.743f, 34.704f)
                curveTo(38.743f, 26.611f, 31.618f, 19.746f, 22.439f, 19.745f)
                curveTo(21.27f, 19.745f, 20.129f, 19.859f, 19.03f, 20.073f)
                curveTo(18.264f, 20.223f, 17.472f, 19.998f, 16.899f, 19.468f)
                curveTo(16.326f, 18.938f, 16.04f, 18.166f, 16.13f, 17.39f)
                curveTo(16.511f, 14.101f, 17.966f, 12.149f, 20.992f, 9.216f)
                curveTo(20.67f, 8.294f, 19.34f, 7.328f, 18.417f, 7.993f)
                close()
            }
        }.build()

        return _IconQuote!!
    }

@Suppress("ObjectPropertyName")
private var _IconQuote: ImageVector? = null
