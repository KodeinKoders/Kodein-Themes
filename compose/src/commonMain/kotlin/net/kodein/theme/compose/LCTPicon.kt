package net.kodein.theme.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import net.kodein.themes.compose.generated.resources.*
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Black
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_ExtraBold
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Thin
import net.kodein.themes.compose.generated.resources.Res
import org.jetbrains.compose.resources.*
import org.jetbrains.compose.resources.FontResource


public object LCTPicon {
    public val Regular: FontFamily @Composable get() = FontFamily(
        Font(resource = Res.font.LCTPicon_Regular_Thin, weight = FontWeight.Thin),
        Font(resource = Res.font.LCTPicon_Regular_ExtraLight, weight = FontWeight.ExtraLight),
        Font(resource = Res.font.LCTPicon_Regular_Light, weight = FontWeight.Light),
        Font(resource = Res.font.LCTPicon_Regular_Normal, weight = FontWeight.Normal),
        Font(resource = Res.font.LCTPicon_Regular_Medium, weight = FontWeight.Medium),
        Font(resource = Res.font.LCTPicon_Regular_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.LCTPicon_Regular_Bold, weight = FontWeight.Bold),
        Font(resource = Res.font.LCTPicon_Regular_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Res.font.LCTPicon_Regular_Black, weight = FontWeight.Black),
    )

    public val Condensed: FontFamily @Composable get() = FontFamily(
        Font(resource = Res.font.LCTPicon_Condensed_Thin, weight = FontWeight.Thin),
        Font(resource = Res.font.LCTPicon_Condensed_ExtraLight, weight = FontWeight.ExtraLight),
        Font(resource = Res.font.LCTPicon_Condensed_Light, weight = FontWeight.Light),
        Font(resource = Res.font.LCTPicon_Condensed_Normal, weight = FontWeight.Normal),
        Font(resource = Res.font.LCTPicon_Condensed_Medium, weight = FontWeight.Medium),
        Font(resource = Res.font.LCTPicon_Condensed_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.LCTPicon_Condensed_Bold, weight = FontWeight.Bold),
        Font(resource = Res.font.LCTPicon_Condensed_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Res.font.LCTPicon_Condensed_Black, weight = FontWeight.Black),
    )

    public val Extended: FontFamily @Composable get() = FontFamily(
        Font(resource = Res.font.LCTPicon_Extended_Thin, weight = FontWeight.Thin),
        Font(resource = Res.font.LCTPicon_Extended_ExtraLight, weight = FontWeight.ExtraLight),
        Font(resource = Res.font.LCTPicon_Extended_Light, weight = FontWeight.Light),
        Font(resource = Res.font.LCTPicon_Extended_Normal, weight = FontWeight.Normal),
        Font(resource = Res.font.LCTPicon_Extended_Medium, weight = FontWeight.Medium),
        Font(resource = Res.font.LCTPicon_Extended_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.LCTPicon_Extended_Bold, weight = FontWeight.Bold),
        Font(resource = Res.font.LCTPicon_Extended_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Res.font.LCTPicon_Extended_Black, weight = FontWeight.Black),
    )

}