package net.kodein.theme.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource


@OptIn(ExperimentalResourceApi::class)
private object JetBrainsMonoResources {
    val Thin: FontResource by lazy { FontResource("font/JetBrainsMono-Thin.ttf") }
    val ThinItalic: FontResource by lazy { FontResource("font/JetBrainsMono-ThinItalic.ttf") }
    val ExtraLight: FontResource by lazy { FontResource("font/JetBrainsMono-ExtraLight.ttf") }
    val ExtraLightItalic: FontResource by lazy { FontResource("font/JetBrainsMono-ExtraLightItalic.ttf") }
    val Light: FontResource by lazy { FontResource("font/JetBrainsMono-Light.ttf") }
    val LightItalic: FontResource by lazy { FontResource("font/JetBrainsMono-LightItalic.ttf") }
    val Regular: FontResource by lazy { FontResource("font/JetBrainsMono-Regular.ttf") }
    val Italic: FontResource by lazy { FontResource("font/JetBrainsMono-Italic.ttf") }
    val Medium: FontResource by lazy { FontResource("font/JetBrainsMono-Medium.ttf") }
    val MediumItalic: FontResource by lazy { FontResource("font/JetBrainsMono-MediumItalic.ttf") }
    val SemiBold: FontResource by lazy { FontResource("font/JetBrainsMono-SemiBold.ttf") }
    val SemiBoldItalic: FontResource by lazy { FontResource("font/JetBrainsMono-SemiBoldItalic.ttf") }
    val Bold: FontResource by lazy { FontResource("font/JetBrainsMono-Bold.ttf") }
    val BoldItalic: FontResource by lazy { FontResource("font/JetBrainsMono-BoldItalic.ttf") }
    val ExtraBold: FontResource by lazy { FontResource("font/JetBrainsMono-ExtraBold.ttf") }
    val ExtraBoldItalic: FontResource by lazy { FontResource("font/JetBrainsMono-ExtraBoldItalic.ttf") }
}

@OptIn(ExperimentalResourceApi::class)
public val JetBrainsMono: FontFamily @Composable get() = FontFamily(
    Font(resource = JetBrainsMonoResources.Thin, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.ThinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoResources.ExtraLight, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoResources.Light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoResources.Regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoResources.Medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoResources.SemiBold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoResources.Bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoResources.ExtraBold, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoResources.ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
)
