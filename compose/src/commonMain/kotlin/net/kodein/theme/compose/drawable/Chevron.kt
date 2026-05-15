package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.Chevron: ImageVector
    get() {
        if (_Chevron != null) {
            return _Chevron!!
        }
        _Chevron = ImageVector.Builder(
            name = "Chevron",
            defaultWidth = 41.dp,
            defaultHeight = 25.dp,
            viewportWidth = 41f,
            viewportHeight = 25f,
        ).apply {
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(1.175f, 6.849f)
                curveTo(-0.392f, 5.282f, -0.392f, 2.742f, 1.175f, 1.175f)
                curveTo(2.742f, -0.392f, 5.283f, -0.392f, 6.85f, 1.175f)
                lineTo(20.157f, 10.47f)
                lineTo(33.465f, 1.175f)
                curveTo(35.032f, -0.392f, 37.572f, -0.392f, 39.139f, 1.175f)
                curveTo(40.706f, 2.742f, 40.706f, 5.282f, 39.139f, 6.849f)
                lineTo(22.994f, 22.994f)
                curveTo(21.427f, 24.561f, 18.887f, 24.561f, 17.32f, 22.994f)
                lineTo(1.175f, 6.849f)
                close()
            }
        }.build()

        return _Chevron!!
    }

@Suppress("ObjectPropertyName")
private var _Chevron: ImageVector? = null
