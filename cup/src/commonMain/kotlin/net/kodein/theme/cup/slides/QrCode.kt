package net.kodein.theme.cup.slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.qrose.options.QrBallShape
import io.github.alexzhirkevich.qrose.options.QrBrush
import io.github.alexzhirkevich.qrose.options.QrColors
import io.github.alexzhirkevich.qrose.options.QrFrameShape
import io.github.alexzhirkevich.qrose.options.QrPixelShape
import io.github.alexzhirkevich.qrose.options.QrShapes
import io.github.alexzhirkevich.qrose.options.circle
import io.github.alexzhirkevich.qrose.options.roundCorners
import io.github.alexzhirkevich.qrose.options.solid
import io.github.alexzhirkevich.qrose.rememberQrCodePainter
import net.kodein.theme.compose.Link


@Composable
public fun QrCode(
    data: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = rememberQrCodePainter(
            data = data,
            shapes = QrShapes(
                ball = QrBallShape.roundCorners(.25f),
                frame = QrFrameShape.roundCorners(.25f),
                darkPixel = QrPixelShape.circle(),
            ),
            colors = QrColors(
                dark = QrBrush.solid(LocalContentColor.current)
            )
        ),
        contentDescription = contentDescription,
        modifier = modifier
    )

}

@Composable
public fun UrlQrCode(
    url: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        QrCode(
            data = url,
            contentDescription = "QRCode for $url",
            modifier = Modifier.padding(8.dp).size(64.dp)
        )
        Link(
            uri = url
        ) {
            Text(
                text = url,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}
