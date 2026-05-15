package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.Circular: ImageVector
    get() {
        if (_Circular != null) {
            return _Circular!!
        }
        _Circular = ImageVector.Builder(
            name = "Circular",
            defaultWidth = 101.dp,
            defaultHeight = 96.dp,
            viewportWidth = 101f,
            viewportHeight = 96f,
        ).apply {
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(28.52f, 0f)
                curveTo(22.74f, 0f, 18.04f, 4.7f, 18.04f, 10.48f)
                curveTo(18.04f, 16.26f, 22.74f, 20.97f, 28.52f, 20.97f)
                curveTo(34.3f, 20.97f, 39f, 16.26f, 39f, 10.48f)
                curveTo(39f, 4.7f, 34.3f, 0f, 28.52f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(84.36f, 55.84f)
                curveTo(78.58f, 55.84f, 73.88f, 60.55f, 73.88f, 66.33f)
                curveTo(73.88f, 72.11f, 78.58f, 76.81f, 84.36f, 76.81f)
                curveTo(90.14f, 76.81f, 94.84f, 72.11f, 94.84f, 66.33f)
                curveTo(94.84f, 60.55f, 90.14f, 55.84f, 84.36f, 55.84f)
                close()
                moveTo(84.36f, 82.62f)
                curveTo(75.37f, 82.62f, 68.06f, 75.31f, 68.06f, 66.33f)
                curveTo(68.06f, 57.34f, 75.37f, 50.03f, 84.36f, 50.03f)
                curveTo(93.35f, 50.03f, 100.65f, 57.34f, 100.65f, 66.33f)
                curveTo(100.65f, 75.31f, 93.35f, 82.62f, 84.36f, 82.62f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(72.42f, 12.63f)
                curveTo(63.81f, 6.38f, 53.59f, 3.49f, 43.46f, 3.99f)
                curveTo(44.23f, 5.78f, 44.69f, 7.73f, 44.78f, 9.77f)
                curveTo(45.08f, 9.76f, 45.39f, 9.74f, 45.7f, 9.74f)
                curveTo(53.89f, 9.74f, 62.05f, 12.28f, 69.01f, 17.33f)
                curveTo(79.77f, 25.13f, 85.67f, 37.23f, 85.4f, 50.08f)
                curveTo(87.46f, 50.21f, 89.4f, 50.72f, 91.18f, 51.54f)
                curveTo(91.95f, 36.3f, 85.14f, 21.85f, 72.42f, 12.63f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(62.2f, 50.03f)
                curveTo(62.2f, 59.86f, 54.23f, 67.83f, 44.4f, 67.83f)
                curveTo(34.58f, 67.83f, 26.61f, 59.86f, 26.61f, 50.03f)
                curveTo(26.61f, 40.2f, 34.58f, 32.24f, 44.4f, 32.24f)
                curveTo(54.23f, 32.24f, 62.2f, 40.2f, 62.2f, 50.03f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(54.08f, 88.3f)
                curveTo(31.46f, 93.19f, 15.06f, 79.77f, 8.84f, 64.3f)
                curveTo(3.58f, 51.24f, 4.63f, 34.22f, 16.94f, 21.93f)
                curveTo(15.54f, 20.51f, 14.4f, 18.84f, 13.59f, 17f)
                curveTo(-1.37f, 31.15f, -2.7f, 51.18f, 3.45f, 66.47f)
                curveTo(9.56f, 81.68f, 24.26f, 95.15f, 44.67f, 95.15f)
                curveTo(48.06f, 95.15f, 51.61f, 94.78f, 55.31f, 93.98f)
                curveTo(64.32f, 92.03f, 72.19f, 87.62f, 78.26f, 81.43f)
                curveTo(76.38f, 80.67f, 74.68f, 79.56f, 73.22f, 78.2f)
                curveTo(68.05f, 83.15f, 61.51f, 86.69f, 54.08f, 88.3f)
                close()
            }
        }.build()

        return _Circular!!
    }

@Suppress("ObjectPropertyName")
private var _Circular: ImageVector? = null
