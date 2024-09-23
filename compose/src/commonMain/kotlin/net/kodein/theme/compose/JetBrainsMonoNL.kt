package net.kodein.theme.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import net.kodein.themes.compose.generated.resources.*
import org.jetbrains.compose.resources.Font


public val JetBrainsMonoNL: FontFamily @Composable get() = FontFamily(
    Font(resource = Res.font.JetBrainsMonoNL_Thin, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_ThinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMonoNL_ExtraLight, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMonoNL_Light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMonoNL_Regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMonoNL_Medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMonoNL_SemiBold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMonoNL_Bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMonoNL_ExtraBold, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMonoNL_ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
)
