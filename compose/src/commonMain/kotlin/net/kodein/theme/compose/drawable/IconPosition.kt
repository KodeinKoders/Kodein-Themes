package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconPosition: ImageVector
    get() {
        if (_IconPosition != null) {
            return _IconPosition!!
        }
        _IconPosition = ImageVector.Builder(
            name = "IconPosition",
            defaultWidth = 50.dp,
            defaultHeight = 64.dp,
            viewportWidth = 50f,
            viewportHeight = 64f,
        ).apply {
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(24.569f, 0f)
                curveTo(38.138f, 0f, 49.138f, 11f, 49.138f, 24.568f)
                curveTo(49.138f, 31.79f, 46.021f, 38.284f, 41.06f, 42.779f)
                lineTo(27.995f, 61.896f)
                curveTo(26.308f, 64.364f, 22.669f, 64.37f, 20.973f, 61.908f)
                lineTo(7.368f, 42.157f)
                lineTo(7.425f, 42.164f)
                curveTo(2.845f, 37.701f, 0f, 31.468f, 0f, 24.568f)
                curveTo(0f, 11f, 11f, 0f, 24.569f, 0f)
                close()
                moveTo(24.569f, 5.974f)
                curveTo(14.3f, 5.974f, 5.974f, 14.299f, 5.974f, 24.568f)
                curveTo(5.974f, 34.838f, 14.299f, 43.164f, 24.569f, 43.164f)
                curveTo(34.839f, 43.164f, 43.164f, 34.838f, 43.164f, 24.568f)
                curveTo(43.164f, 14.299f, 34.839f, 5.974f, 24.569f, 5.974f)
                close()
                moveTo(24.569f, 17.813f)
                curveTo(28.301f, 17.813f, 31.325f, 20.838f, 31.325f, 24.569f)
                curveTo(31.325f, 28.301f, 28.301f, 31.325f, 24.569f, 31.325f)
                curveTo(20.838f, 31.325f, 17.813f, 28.301f, 17.813f, 24.569f)
                curveTo(17.813f, 20.838f, 20.838f, 17.813f, 24.569f, 17.813f)
                close()
            }
        }.build()

        return _IconPosition!!
    }

@Suppress("ObjectPropertyName")
private var _IconPosition: ImageVector? = null
