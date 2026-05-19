package net.kodein.theme.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.takeOrElse
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.drawable.KodeinVectors
import net.kodein.theme.compose.drawable.Monogram

@Composable
public fun KodeinLogo(
    division: String,
    modifier: Modifier = Modifier,
    mainFontSize: TextUnit = TextUnit.Unspecified,
    logoColor: Color = Color(KodeinColors.orange600),
    textColor: Color = Color(KodeinColors.orange100),
    showDesignLines: Boolean = false,
    subtext: @Composable () -> Unit
) {
    val lineColor = lerp(textColor, logoColor, 0.5f).copy(alpha = 0.8f)

    val fontSize = mainFontSize.takeOrElse { LocalTextStyle.current.fontSize }

    val logoHeightInFontSize = 2.775514f
    val logoWidthInHeight = 0.7946182f
    val spaceWidthInFontSize = 0.94f
    val circleSizeInHeight = 0.25718683f
    val firstCircleTopInHeight = 0.19210806f
    val secondCircleTopInHeight = 0.55059946f

    val density = LocalDensity.current
    val logoHeight = with(density) { (fontSize.toPx() * logoHeightInFontSize).toDp() }
    val logoWidth = logoHeight * logoWidthInHeight
    val spaceWith = with(density) { (fontSize.toPx() * spaceWidthInFontSize).toDp() }
    val firstTextTop = logoHeight * firstCircleTopInHeight
    val secondTextTop = logoHeight * secondCircleTopInHeight

    Box(
        modifier = modifier
            .height(logoHeight)
            .drawWithContent {
                drawContent()
                if (showDesignLines) {
                    listOf(
                        firstCircleTopInHeight,
                        firstCircleTopInHeight + circleSizeInHeight,
                        secondCircleTopInHeight,
                        secondCircleTopInHeight + circleSizeInHeight,
                    ).forEach {
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, size.height * it),
                            end = Offset(size.width, size.height * it)
                        )
                    }
                    drawLine(
                        color = lineColor,
                        start = Offset(size.height * 0.7946182f, 0f),
                        end = Offset(size.height * 0.7946182f, size.height)
                    )
                    drawLine(
                        color = lineColor,
                        start = Offset(size.height * 0.7946182f + spaceWith.toPx(), 0f),
                        end = Offset(size.height * 0.7946182f + spaceWith.toPx(), size.height)
                    )
                }
            }
    ) {
        // Not using ProvideTextStyle because we want to fully ignore outside font configuration.
        CompositionLocalProvider(
            LocalTextStyle provides TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = fontSize,
                lineHeight = fontSize,
            ),
            LocalContentColor provides textColor,
        ) {
            Image(
                painter = rememberVectorPainter(KodeinVectors.Monogram),
                contentDescription = null,
                colorFilter = ColorFilter.tint(logoColor),
                modifier = Modifier
                    .fillMaxHeight()
            )
            if (showDesignLines) {
                Text(
                    text = "m",
                    fontWeight = FontWeight.Black,
                    fontSize = fontSize,
                    color = lineColor,
                    modifier = Modifier
                        .padding(
                            start = logoWidth - with(density) { (fontSize.toPx() * 0.04f).toDp() },
                        )
                        .graphicsLayer {
                            translationY = -fontSize.toPx() * 0.34f
                            alpha = .6f
                        }
                )
            }
            Text(
                text = "Kodein $division",
                color = textColor,
                fontWeight = FontWeight.Black,
                fontSize = fontSize,
                lineHeight = fontSize * 0.6,
                modifier = Modifier
                    .padding(
                        start = logoWidth + spaceWith - with(density) { (fontSize.toPx() * 0.04f).toDp() },
                        top = firstTextTop - with(density) { (fontSize.toPx() * 0.16f).toDp() },
                    )
            )
            Box(
                modifier = Modifier
                    .padding(
                        start = logoWidth + spaceWith - with(density) { (fontSize.toPx() * 0.04f).toDp() },
                        top = secondTextTop - with(density) { (fontSize.toPx() * 0.04f).toDp() },
                    )
            ) {
                ProvideTextStyle(
                    TextStyle(
                        fontSize = fontSize * .7f,
                        lineHeight = fontSize * .7f,
                        fontWeight = FontWeight.Normal,
                    )
                ) {
                    subtext()
                }
            }
        }
    }
}