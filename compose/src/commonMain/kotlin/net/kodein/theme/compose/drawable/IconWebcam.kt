package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconWebcam: ImageVector
    get() {
        if (_IconWebcam != null) {
            return _IconWebcam!!
        }
        _IconWebcam = ImageVector.Builder(
            name = "IconWebcam",
            defaultWidth = 50.dp,
            defaultHeight = 65.dp,
            viewportWidth = 50f,
            viewportHeight = 65f,
        ).apply {
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(24.886f, 54.303f)
                curveTo(31.607f, 54.303f, 37.382f, 56.834f, 39.903f, 60.453f)
                curveTo(41.281f, 62.431f, 39.301f, 64.53f, 36.892f, 64.53f)
                horizontalLineTo(12.88f)
                curveTo(10.47f, 64.53f, 8.491f, 62.431f, 9.868f, 60.453f)
                curveTo(12.389f, 56.834f, 18.164f, 54.303f, 24.886f, 54.303f)
                close()
                moveTo(24.886f, 0f)
                curveTo(38.63f, 0f, 49.771f, 11.142f, 49.771f, 24.886f)
                curveTo(49.771f, 38.629f, 38.63f, 49.771f, 24.886f, 49.771f)
                curveTo(11.142f, 49.771f, 0f, 38.629f, 0f, 24.886f)
                curveTo(0f, 11.142f, 11.142f, 0f, 24.886f, 0f)
                close()
                moveTo(24.886f, 6.05f)
                curveTo(14.483f, 6.05f, 6.051f, 14.483f, 6.051f, 24.886f)
                curveTo(6.051f, 35.288f, 14.483f, 43.721f, 24.886f, 43.721f)
                curveTo(35.288f, 43.721f, 43.721f, 35.288f, 43.721f, 24.886f)
                curveTo(43.721f, 14.483f, 35.288f, 6.05f, 24.886f, 6.05f)
                close()
                moveTo(24.886f, 18.042f)
                curveTo(28.665f, 18.042f, 31.729f, 21.106f, 31.729f, 24.886f)
                curveTo(31.729f, 28.665f, 28.665f, 31.729f, 24.886f, 31.729f)
                curveTo(21.106f, 31.729f, 18.042f, 28.665f, 18.042f, 24.886f)
                curveTo(18.042f, 21.106f, 21.106f, 18.042f, 24.886f, 18.042f)
                close()
            }
        }.build()

        return _IconWebcam!!
    }

@Suppress("ObjectPropertyName")
private var _IconWebcam: ImageVector? = null
