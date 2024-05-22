package net.kodein.theme.cup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinVectorImages
import net.kodein.theme.compose.img.KodeinMonogram
import net.kodein.theme.cup.kStyled

@Composable
public fun KodeinLogo(
    division: String,
    modifier: Modifier = Modifier,
    color: Color = Color(KodeinColors.orange),
    url: String = "https://kodein.net",
    subtext: @Composable () -> Unit
) {
    val uriHandler = LocalUriHandler.current
    val density = LocalDensity.current
    var height: Dp by remember { mutableStateOf(0.dp) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(112.dp)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { uriHandler.openUri(url) }
            .onSizeChanged { height = with(density) { it.height.toDp() } }
    ) {
        if (height == 0.dp) return@Row
        Image(
            painter = rememberVectorPainter(KodeinVectorImages.Logo.KodeinMonogram),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color),
            modifier = Modifier.fillMaxHeight().padding(end = height * 0.1f)
        )
        Column {
            val mainFontSize = with(density) { (height * 0.5f).toSp() }
            Text(
                text = kStyled { "KODEIN${+l}$division${-l}" },
                color = color,
                fontWeight = FontWeight.Bold,
                fontSize = mainFontSize,
                lineHeight = mainFontSize,
                modifier = Modifier.height(height * 0.41f)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = height * 0.02f)
            ) {
                val subFontSize = with(density) { (height * 0.2f).toSp() }
                ProvideTextStyle(
                    TextStyle(
                        color = color,
                        fontSize = subFontSize,
                        lineHeight = subFontSize
                    )
                ) {
                    subtext()
                }
            }
        }
    }
}