package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconFormations: ImageVector
    get() {
        if (_IconFormations != null) {
            return _IconFormations!!
        }
        _IconFormations = ImageVector.Builder(
            name = "IconFormations",
            defaultWidth = 69.dp,
            defaultHeight = 98.dp,
            viewportWidth = 69f,
            viewportHeight = 98f,
        ).apply {
            path(fill = SolidColor(Color(0xFFF0A698))) {
                moveTo(32.484f, 73.094f)
                lineTo(47.098f, 87.039f)
                verticalLineTo(96.93f)
                curveTo(47.098f, 97.712f, 46.149f, 98.099f, 45.597f, 97.549f)
                lineTo(34.68f, 86.688f)
                curveTo(34.641f, 86.65f, 34.6f, 86.617f, 34.557f, 86.588f)
                lineTo(34.061f, 86.07f)
                lineTo(21.021f, 74.403f)
                verticalLineTo(73.969f)
                curveTo(21.021f, 73.486f, 21.413f, 73.094f, 21.899f, 73.094f)
                horizontalLineTo(32.484f)
                close()
                moveTo(31.194f, 88.918f)
                lineTo(22.521f, 97.549f)
                curveTo(21.965f, 98.099f, 21.021f, 97.708f, 21.021f, 96.93f)
                verticalLineTo(79.815f)
                lineTo(31.194f, 88.918f)
                close()
                moveTo(46.219f, 73.094f)
                curveTo(46.705f, 73.094f, 47.098f, 73.486f, 47.098f, 73.969f)
                verticalLineTo(81.463f)
                lineTo(38.328f, 73.094f)
                horizontalLineTo(46.219f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(34.059f, 33.681f)
                moveToRelative(-5.677f, 0f)
                arcToRelative(5.677f, 5.677f, 0f, isMoreThanHalf = true, isPositiveArc = true, 11.355f, 0f)
                arcToRelative(5.677f, 5.677f, 0f, isMoreThanHalf = true, isPositiveArc = true, -11.355f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFFE84420)),
                strokeLineWidth = 5.30726f,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(34.055f, 6.233f)
                lineTo(41.626f, 2.654f)
                lineTo(46.662f, 9.329f)
                lineTo(55.034f, 9.658f)
                lineTo(56.375f, 17.892f)
                lineTo(63.638f, 22.057f)
                lineTo(60.976f, 29.97f)
                lineTo(65.464f, 37.022f)
                lineTo(59.417f, 42.796f)
                lineTo(60.091f, 51.107f)
                lineTo(52.042f, 53.427f)
                lineTo(48.762f, 61.102f)
                lineTo(40.545f, 59.431f)
                lineTo(34.055f, 64.709f)
                lineTo(27.566f, 59.431f)
                lineTo(19.355f, 61.102f)
                lineTo(16.075f, 53.427f)
                lineTo(8.02f, 51.107f)
                lineTo(8.701f, 42.796f)
                lineTo(2.654f, 37.022f)
                lineTo(7.135f, 29.97f)
                lineTo(4.48f, 22.057f)
                lineTo(11.742f, 17.892f)
                lineTo(13.076f, 9.658f)
                lineTo(21.455f, 9.329f)
                lineTo(26.484f, 2.654f)
                lineTo(34.055f, 6.233f)
                close()
            }
        }.build()

        return _IconFormations!!
    }

@Suppress("ObjectPropertyName")
private var _IconFormations: ImageVector? = null
