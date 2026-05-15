package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconSchool: ImageVector
    get() {
        if (_IconSchool != null) {
            return _IconSchool!!
        }
        _IconSchool = ImageVector.Builder(
            name = "IconSchool",
            defaultWidth = 81.dp,
            defaultHeight = 77.dp,
            viewportWidth = 81f,
            viewportHeight = 77f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFFE84420)),
                pathFillType = PathFillType.EvenOdd,
            ) {
                moveTo(36.765f, 0.799f)
                curveTo(39.088f, -0.266f, 41.76f, -0.266f, 44.082f, 0.799f)
                lineTo(75.732f, 15.32f)
                curveTo(82.511f, 18.43f, 82.551f, 28.022f, 75.854f, 31.21f)
                verticalLineTo(62.638f)
                curveTo(78.168f, 63.854f, 79.748f, 66.281f, 79.748f, 69.076f)
                curveTo(79.748f, 73.09f, 76.492f, 76.345f, 72.478f, 76.345f)
                curveTo(68.464f, 76.345f, 65.21f, 73.09f, 65.209f, 69.076f)
                curveTo(65.209f, 66.28f, 66.79f, 63.853f, 69.105f, 62.637f)
                verticalLineTo(34.31f)
                lineTo(44.082f, 45.789f)
                curveTo(41.76f, 46.855f, 39.088f, 46.855f, 36.765f, 45.789f)
                lineTo(5.115f, 31.27f)
                curveTo(-1.705f, 28.14f, -1.705f, 18.449f, 5.115f, 15.32f)
                lineTo(36.765f, 0.799f)
                close()
                moveTo(53.849f, 47.065f)
                curveTo(55.398f, 46.354f, 57.182f, 46.353f, 58.731f, 47.064f)
                curveTo(63.279f, 49.151f, 63.278f, 55.615f, 58.73f, 57.701f)
                lineTo(43.483f, 64.697f)
                curveTo(41.54f, 65.588f, 39.305f, 65.588f, 37.363f, 64.697f)
                lineTo(22.117f, 57.701f)
                curveTo(17.568f, 55.615f, 17.567f, 49.151f, 22.116f, 47.064f)
                curveTo(23.665f, 46.353f, 25.447f, 46.354f, 26.996f, 47.065f)
                lineTo(39.403f, 52.756f)
                curveTo(40.05f, 53.053f, 40.795f, 53.053f, 41.443f, 52.756f)
                lineTo(53.849f, 47.065f)
                close()
                moveTo(41.268f, 6.933f)
                curveTo(40.732f, 6.687f, 40.115f, 6.687f, 39.579f, 6.933f)
                lineTo(7.929f, 21.454f)
                curveTo(6.356f, 22.177f, 6.355f, 24.414f, 7.929f, 25.136f)
                lineTo(39.579f, 39.656f)
                curveTo(40.115f, 39.901f, 40.732f, 39.901f, 41.268f, 39.656f)
                lineTo(72.919f, 25.136f)
                curveTo(74.493f, 24.414f, 74.492f, 22.177f, 72.919f, 21.454f)
                lineTo(41.268f, 6.933f)
                close()
            }
        }.build()

        return _IconSchool!!
    }

@Suppress("ObjectPropertyName")
private var _IconSchool: ImageVector? = null
