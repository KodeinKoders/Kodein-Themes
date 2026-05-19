package net.kodein.theme.cup.drawable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinCupVectors.Kotlin: ImageVector
    get() {
        if (_Kotlin != null) {
            return _Kotlin!!
        }
        _Kotlin = ImageVector.Builder(
            name = "Kotlin",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 48f,
            viewportHeight = 48f,
        ).apply {
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE44857),
                        0.5f to Color(0xFFC711E1),
                        1f to Color(0xFF7F52FF)
                    ),
                    center = Offset(48f, -0.2f),
                    radius = 48f
                )
            ) {
                moveTo(48f, 48f)
                horizontalLineTo(0f)
                verticalLineTo(0f)
                horizontalLineToRelative(48f)
                lineToRelative(-24.5f, 23.65f)
                lineToRelative(24.5f, 24.35f)
                close()
            }
        }.build()

        return _Kotlin!!
    }

@Suppress("ObjectPropertyName")
private var _Kotlin: ImageVector? = null
