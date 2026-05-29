package net.kodein.theme.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_Black
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_BlackOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_Bold
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_BoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_ExtraBold
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_ExtraBoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_Hairline
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_HairlineOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_Light
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_LightOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_Medium
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_MediumOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_Normal
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_NormalOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_SemiBold
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_SemiBoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_UltraLight
import net.kodein.themes.compose.generated.resources.LCTPicon_Condensed_UltraLightOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_Black
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_BlackOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_Bold
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_BoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_ExtraBold
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_ExtraBoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_Hairline
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_HairlineOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_Light
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_LightOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_Medium
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_MediumOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_Normal
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_NormalOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_SemiBold
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_SemiBoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_UltraLight
import net.kodein.themes.compose.generated.resources.LCTPicon_Extended_UltraLightOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Black
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_BlackOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Bold
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_BoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_ExtraBold
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_ExtraBoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Hairline
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_HairlineOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Light
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_LightOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Medium
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_MediumOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_Normal
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_NormalOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_SemiBold
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_SemiBoldOblique
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_UltraLight
import net.kodein.themes.compose.generated.resources.LCTPicon_Regular_UltraLightOblique
import net.kodein.themes.compose.generated.resources.Res
import org.jetbrains.compose.resources.Font


public object LCTPicon {
    public val Regular: FontFamily @Composable get() = FontFamily(
        Font(resource = Res.font.LCTPicon_Regular_Hairline, weight = FontWeight.Thin),
        Font(resource = Res.font.LCTPicon_Regular_HairlineOblique, weight = FontWeight.Thin, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_UltraLight, weight = FontWeight.ExtraLight),
        Font(resource = Res.font.LCTPicon_Regular_UltraLightOblique, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_Light, weight = FontWeight.Light),
        Font(resource = Res.font.LCTPicon_Regular_LightOblique, weight = FontWeight.Light, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_Normal, weight = FontWeight.Normal),
        Font(resource = Res.font.LCTPicon_Regular_NormalOblique, weight = FontWeight.Normal, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_Medium, weight = FontWeight.Medium),
        Font(resource = Res.font.LCTPicon_Regular_MediumOblique, weight = FontWeight.Medium, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.LCTPicon_Regular_SemiBoldOblique, weight = FontWeight.SemiBold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_Bold, weight = FontWeight.Bold),
        Font(resource = Res.font.LCTPicon_Regular_BoldOblique, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Res.font.LCTPicon_Regular_ExtraBoldOblique, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Regular_Black, weight = FontWeight.Black),
        Font(resource = Res.font.LCTPicon_Regular_BlackOblique, weight = FontWeight.Black, style = FontStyle.Italic),
    )

    public val Condensed: FontFamily @Composable get() = FontFamily(
        Font(resource = Res.font.LCTPicon_Condensed_Hairline, weight = FontWeight.Thin),
        Font(resource = Res.font.LCTPicon_Condensed_HairlineOblique, weight = FontWeight.Thin, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_UltraLight, weight = FontWeight.ExtraLight),
        Font(resource = Res.font.LCTPicon_Condensed_UltraLightOblique, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_Light, weight = FontWeight.Light),
        Font(resource = Res.font.LCTPicon_Condensed_LightOblique, weight = FontWeight.Light, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_Normal, weight = FontWeight.Normal),
        Font(resource = Res.font.LCTPicon_Condensed_NormalOblique, weight = FontWeight.Normal, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_Medium, weight = FontWeight.Medium),
        Font(resource = Res.font.LCTPicon_Condensed_MediumOblique, weight = FontWeight.Medium, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.LCTPicon_Condensed_SemiBoldOblique, weight = FontWeight.SemiBold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_Bold, weight = FontWeight.Bold),
        Font(resource = Res.font.LCTPicon_Condensed_BoldOblique, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Res.font.LCTPicon_Condensed_ExtraBoldOblique, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Condensed_Black, weight = FontWeight.Black),
        Font(resource = Res.font.LCTPicon_Condensed_BlackOblique, weight = FontWeight.Black, style = FontStyle.Italic),
    )

    public val Extended: FontFamily @Composable get() = FontFamily(
        Font(resource = Res.font.LCTPicon_Extended_Hairline, weight = FontWeight.Thin),
        Font(resource = Res.font.LCTPicon_Extended_HairlineOblique, weight = FontWeight.Thin, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_UltraLight, weight = FontWeight.ExtraLight),
        Font(resource = Res.font.LCTPicon_Extended_UltraLightOblique, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_Light, weight = FontWeight.Light),
        Font(resource = Res.font.LCTPicon_Extended_LightOblique, weight = FontWeight.Light, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_Normal, weight = FontWeight.Normal),
        Font(resource = Res.font.LCTPicon_Extended_NormalOblique, weight = FontWeight.Normal, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_Medium, weight = FontWeight.Medium),
        Font(resource = Res.font.LCTPicon_Extended_MediumOblique, weight = FontWeight.Medium, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.LCTPicon_Extended_SemiBoldOblique, weight = FontWeight.SemiBold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_Bold, weight = FontWeight.Bold),
        Font(resource = Res.font.LCTPicon_Extended_BoldOblique, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Res.font.LCTPicon_Extended_ExtraBoldOblique, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
        Font(resource = Res.font.LCTPicon_Extended_Black, weight = FontWeight.Black),
        Font(resource = Res.font.LCTPicon_Extended_BlackOblique, weight = FontWeight.Black, style = FontStyle.Italic),
    )

}