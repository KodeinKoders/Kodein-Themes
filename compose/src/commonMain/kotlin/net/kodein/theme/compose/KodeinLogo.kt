package net.kodein.theme.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinVectorImages
import net.kodein.theme.compose.img.KodeinFull


@Composable
public fun KodeinLogo(modifier: Modifier) {
    val uriHandler = LocalUriHandler.current
    Image(
        painter = rememberVectorPainter(KodeinVectorImages.Logo.KodeinFull),
        contentDescription = "Kodein Koders",
        colorFilter = ColorFilter.tint(Color(KodeinColors.orange)),
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable {
                uriHandler.openUri("https://kodein.net")
            }
    )
}