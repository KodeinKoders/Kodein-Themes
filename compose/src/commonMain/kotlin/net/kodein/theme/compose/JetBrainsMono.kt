package net.kodein.theme.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import net.kodein.themes.compose.generated.resources.*
import net.kodein.themes.compose.generated.resources.JetBrainsMono_ExtraBold
import net.kodein.themes.compose.generated.resources.JetBrainsMono_ExtraBoldItalic
import net.kodein.themes.compose.generated.resources.JetBrainsMono_Thin
import net.kodein.themes.compose.generated.resources.Res
import org.jetbrains.compose.resources.*


public val JetBrainsMono: FontFamily @Composable get() = FontFamily(
    Font(resource = Res.font.JetBrainsMono_Thin, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_ThinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMono_ExtraLight, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMono_Light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMono_Regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMono_Medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMono_SemiBold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMono_Bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resource = Res.font.JetBrainsMono_ExtraBold, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(resource = Res.font.JetBrainsMono_ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
)
