package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconTerminal: ImageVector
    get() {
        if (_IconTerminal != null) {
            return _IconTerminal!!
        }
        _IconTerminal = ImageVector.Builder(
            name = "IconTerminal",
            defaultWidth = 68.dp,
            defaultHeight = 63.dp,
            viewportWidth = 68f,
            viewportHeight = 63f,
        ).apply {
            path(
                stroke = SolidColor(Color(0xFFE84420)),
                strokeLineWidth = 4.7998f,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(15.964f, 5.892f)
                lineTo(51.816f, 5.892f)
                arcTo(13.564f, 13.564f, 0f, isMoreThanHalf = false, isPositiveArc = true, 65.38f, 19.456f)
                lineTo(65.38f, 43.38f)
                arcTo(13.564f, 13.564f, 0f, isMoreThanHalf = false, isPositiveArc = true, 51.816f, 56.944f)
                lineTo(15.964f, 56.944f)
                arcTo(13.564f, 13.564f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.4f, 43.38f)
                lineTo(2.4f, 19.456f)
                arcTo(13.564f, 13.564f, 0f, isMoreThanHalf = false, isPositiveArc = true, 15.964f, 5.892f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(13.487f, 14.25f)
                curveTo(14.424f, 13.313f, 15.943f, 13.313f, 16.881f, 14.25f)
                lineTo(25.488f, 22.856f)
                curveTo(26.425f, 23.793f, 26.425f, 25.313f, 25.488f, 26.25f)
                lineTo(16.881f, 34.856f)
                curveTo(15.944f, 35.793f, 14.424f, 35.793f, 13.487f, 34.856f)
                curveTo(12.55f, 33.919f, 12.55f, 32.4f, 13.487f, 31.462f)
                lineTo(18.262f, 24.552f)
                lineTo(13.487f, 17.643f)
                curveTo(12.55f, 16.706f, 12.55f, 15.187f, 13.487f, 14.25f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFF0A698)),
                strokeLineWidth = 4.7998f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(28.347f, 34.774f)
                lineTo(39.433f, 34.774f)
            }
            path(
                stroke = SolidColor(Color(0xFFF0A698)),
                strokeLineWidth = 4.7998f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(28.347f, 43.105f)
                lineTo(52.228f, 43.105f)
            }
        }.build()

        return _IconTerminal!!
    }

@Suppress("ObjectPropertyName")
private var _IconTerminal: ImageVector? = null
