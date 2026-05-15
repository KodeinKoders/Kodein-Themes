package net.kodein.theme.compose.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val KodeinVectors.Github: ImageVector
    get() {
        if (_Github != null) {
            return _Github!!
        }
        _Github = ImageVector.Builder(
            name = "Github",
            defaultWidth = 74.dp,
            defaultHeight = 74.dp,
            viewportWidth = 74f,
            viewportHeight = 74f,
        ).apply {
            path(fill = SolidColor(Color(0xFFE84420))) {
                moveTo(36.951f, 0f)
                curveTo(16.535f, 0f, 0f, 16.535f, 0f, 36.951f)
                curveTo(0f, 53.302f, 10.577f, 67.112f, 25.265f, 72.008f)
                curveTo(27.113f, 72.331f, 27.806f, 71.223f, 27.806f, 70.253f)
                curveTo(27.806f, 69.375f, 27.759f, 66.465f, 27.759f, 63.371f)
                curveTo(18.475f, 65.08f, 16.074f, 61.107f, 15.335f, 59.029f)
                curveTo(14.919f, 57.967f, 13.118f, 54.687f, 11.547f, 53.81f)
                curveTo(10.254f, 53.117f, 8.406f, 51.408f, 11.501f, 51.362f)
                curveTo(14.411f, 51.316f, 16.489f, 54.041f, 17.182f, 55.149f)
                curveTo(20.508f, 60.738f, 25.819f, 59.168f, 27.944f, 58.198f)
                curveTo(28.267f, 55.796f, 29.237f, 54.179f, 30.3f, 53.256f)
                curveTo(22.078f, 52.332f, 13.487f, 49.145f, 13.487f, 35.011f)
                curveTo(13.487f, 30.993f, 14.919f, 27.667f, 17.274f, 25.08f)
                curveTo(16.905f, 24.157f, 15.612f, 20.369f, 17.644f, 15.288f)
                curveTo(17.644f, 15.288f, 20.739f, 14.318f, 27.806f, 19.076f)
                curveTo(30.762f, 18.244f, 33.902f, 17.829f, 37.043f, 17.829f)
                curveTo(40.184f, 17.829f, 43.325f, 18.244f, 46.281f, 19.076f)
                curveTo(53.348f, 14.272f, 56.443f, 15.288f, 56.443f, 15.288f)
                curveTo(58.475f, 20.369f, 57.181f, 24.157f, 56.812f, 25.08f)
                curveTo(59.168f, 27.667f, 60.599f, 30.946f, 60.599f, 35.011f)
                curveTo(60.599f, 49.191f, 51.962f, 52.332f, 43.741f, 53.256f)
                curveTo(45.08f, 54.41f, 46.235f, 56.627f, 46.235f, 60.091f)
                curveTo(46.235f, 65.034f, 46.189f, 69.006f, 46.189f, 70.253f)
                curveTo(46.189f, 71.223f, 46.881f, 72.378f, 48.729f, 72.008f)
                curveTo(56.064f, 69.532f, 62.439f, 64.817f, 66.954f, 58.528f)
                curveTo(71.47f, 52.24f, 73.9f, 44.693f, 73.902f, 36.951f)
                curveTo(73.902f, 16.535f, 57.366f, 0f, 36.951f, 0f)
                close()
            }
        }.build()

        return _Github!!
    }

@Suppress("ObjectPropertyName")
private var _Github: ImageVector? = null
