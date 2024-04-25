package net.kodein.theme.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource


@OptIn(ExperimentalResourceApi::class)
private object JetBrainsMonoNLResources {
    val Thin: FontResource by lazy { FontResource("font/JetBrainsMonoNL-Thin.ttf") }
    val ThinItalic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-ThinItalic.ttf") }
    val ExtraLight: FontResource by lazy { FontResource("font/JetBrainsMonoNL-ExtraLight.ttf") }
    val ExtraLightItalic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-ExtraLightItalic.ttf") }
    val Light: FontResource by lazy { FontResource("font/JetBrainsMonoNL-Light.ttf") }
    val LightItalic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-LightItalic.ttf") }
    val Regular: FontResource by lazy { FontResource("font/JetBrainsMonoNL-Regular.ttf") }
    val Italic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-Italic.ttf") }
    val Medium: FontResource by lazy { FontResource("font/JetBrainsMonoNL-Medium.ttf") }
    val MediumItalic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-MediumItalic.ttf") }
    val SemiBold: FontResource by lazy { FontResource("font/JetBrainsMonoNL-SemiBold.ttf") }
    val SemiBoldItalic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-SemiBoldItalic.ttf") }
    val Bold: FontResource by lazy { FontResource("font/JetBrainsMonoNL-Bold.ttf") }
    val BoldItalic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-BoldItalic.ttf") }
    val ExtraBold: FontResource by lazy { FontResource("font/JetBrainsMonoNL-ExtraBold.ttf") }
    val ExtraBoldItalic: FontResource by lazy { FontResource("font/JetBrainsMonoNL-ExtraBoldItalic.ttf") }
}

@OptIn(ExperimentalResourceApi::class)
public val JetBrainsMonoNL: FontFamily @Composable get() = FontFamily(
    Font(resource = JetBrainsMonoNLResources.Thin, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.ThinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoNLResources.ExtraLight, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoNLResources.Light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoNLResources.Regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoNLResources.Medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoNLResources.SemiBold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoNLResources.Bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resource = JetBrainsMonoNLResources.ExtraBold, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(resource = JetBrainsMonoNLResources.ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
)
