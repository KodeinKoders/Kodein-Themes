package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconExternal: ImageVector
    get() {
        if (_IconExternal != null) {
            return _IconExternal!!
        }
        _IconExternal = ImageVector.Builder(
            name = "IconExternal",
            defaultWidth = 81.dp,
            defaultHeight = 79.dp,
            viewportWidth = 81f,
            viewportHeight = 79f,
        ).apply {
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(32.917f, 18.611f)
                curveTo(34.747f, 18.611f, 36.231f, 20.095f, 36.231f, 21.925f)
                curveTo(36.231f, 23.755f, 34.747f, 25.238f, 32.917f, 25.239f)
                horizontalLineTo(30.437f)
                curveTo(24.214f, 25.239f, 19.17f, 30.283f, 19.17f, 36.505f)
                verticalLineTo(48.349f)
                curveTo(19.17f, 54.572f, 24.214f, 59.616f, 30.437f, 59.616f)
                horizontalLineTo(42.281f)
                curveTo(48.503f, 59.616f, 53.547f, 54.573f, 53.548f, 48.351f)
                verticalLineTo(45.129f)
                curveTo(53.548f, 43.299f, 55.032f, 41.815f, 56.861f, 41.815f)
                curveTo(58.691f, 41.815f, 60.177f, 43.299f, 60.177f, 45.129f)
                verticalLineTo(48.351f)
                curveTo(60.176f, 58.233f, 52.163f, 66.245f, 42.281f, 66.245f)
                horizontalLineTo(30.437f)
                curveTo(20.554f, 66.245f, 12.542f, 58.232f, 12.542f, 48.349f)
                verticalLineTo(36.505f)
                curveTo(12.542f, 26.623f, 20.554f, 18.611f, 30.437f, 18.611f)
                horizontalLineTo(32.917f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(63.664f, 12.165f)
                curveTo(66.226f, 12.165f, 68.303f, 14.242f, 68.303f, 16.804f)
                verticalLineTo(29.721f)
                curveTo(68.302f, 34.805f, 61.304f, 36.186f, 59.373f, 31.483f)
                lineTo(57.623f, 27.223f)
                lineTo(46.406f, 38.353f)
                curveTo(45.107f, 39.641f, 43.009f, 39.633f, 41.721f, 38.334f)
                curveTo(40.432f, 37.035f, 40.44f, 34.937f, 41.739f, 33.649f)
                lineTo(52.864f, 22.61f)
                lineTo(49.03f, 21.133f)
                curveTo(44.233f, 19.284f, 45.558f, 12.165f, 50.699f, 12.165f)
                horizontalLineTo(63.664f)
                close()
            }
        }.build()

        return _IconExternal!!
    }

@Suppress("ObjectPropertyName")
private var _IconExternal: ImageVector? = null
