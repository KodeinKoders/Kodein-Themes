package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.IconCheck: ImageVector
    get() {
        if (_IconCheck != null) {
            return _IconCheck!!
        }
        _IconCheck = ImageVector.Builder(
            name = "IconCheck",
            defaultWidth = 96.dp,
            defaultHeight = 96.dp,
            viewportWidth = 96f,
            viewportHeight = 96f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFFE84420)),
                pathFillType = PathFillType.EvenOdd,
            ) {
                moveTo(45.799f, 16.535f)
                curveTo(47.573f, 16.432f, 49.095f, 17.788f, 49.198f, 19.561f)
                curveTo(49.3f, 21.334f, 47.946f, 22.856f, 46.173f, 22.96f)
                curveTo(40.671f, 23.279f, 35.435f, 25.434f, 31.302f, 29.08f)
                curveTo(27.17f, 32.726f, 24.378f, 37.653f, 23.376f, 43.072f)
                curveTo(22.373f, 48.491f, 23.216f, 54.089f, 25.77f, 58.972f)
                curveTo(28.324f, 63.855f, 32.443f, 67.742f, 37.466f, 70.008f)
                curveTo(42.489f, 72.275f, 48.128f, 72.794f, 53.48f, 71.479f)
                curveTo(58.832f, 70.164f, 63.589f, 67.091f, 66.989f, 62.755f)
                curveTo(70.389f, 58.418f, 72.237f, 53.064f, 72.237f, 47.553f)
                curveTo(72.237f, 45.777f, 73.678f, 44.337f, 75.455f, 44.337f)
                curveTo(77.23f, 44.338f, 78.671f, 45.778f, 78.672f, 47.553f)
                curveTo(78.672f, 54.504f, 76.34f, 61.255f, 72.052f, 66.724f)
                curveTo(67.764f, 72.194f, 61.764f, 76.067f, 55.014f, 77.726f)
                curveTo(48.265f, 79.385f, 41.155f, 78.733f, 34.82f, 75.875f)
                curveTo(28.485f, 73.016f, 23.29f, 68.114f, 20.069f, 61.955f)
                curveTo(16.848f, 55.796f, 15.784f, 48.734f, 17.048f, 41.9f)
                curveTo(18.313f, 35.066f, 21.833f, 28.853f, 27.045f, 24.255f)
                curveTo(32.257f, 19.657f, 38.861f, 16.938f, 45.799f, 16.535f)
                close()
                moveTo(69.168f, 20.88f)
                curveTo(70.172f, 19.414f, 72.176f, 19.041f, 73.641f, 20.046f)
                curveTo(75.105f, 21.051f, 75.479f, 23.052f, 74.475f, 24.517f)
                lineTo(51.088f, 56.38f)
                curveTo(50.547f, 57.168f, 49.683f, 57.675f, 48.731f, 57.763f)
                curveTo(47.779f, 57.851f, 46.836f, 57.511f, 46.16f, 56.835f)
                lineTo(34.339f, 45.014f)
                curveTo(33.082f, 43.758f, 33.082f, 41.72f, 34.339f, 40.464f)
                curveTo(35.595f, 39.208f, 37.215f, 39.622f, 38.888f, 40.464f)
                curveTo(40.555f, 41.301f, 47.908f, 44.983f, 47.97f, 45.014f)
                curveTo(47.97f, 45.014f, 68.163f, 22.345f, 69.168f, 20.88f)
                close()
            }
        }.build()

        return _IconCheck!!
    }

@Suppress("ObjectPropertyName")
private var _IconCheck: ImageVector? = null
