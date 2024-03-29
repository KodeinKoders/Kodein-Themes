package net.kodein.theme.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.*
import org.jetbrains.compose.resources.FontResource


@OptIn(ExperimentalResourceApi::class)
public object LCTPicon {
    internal object Resources {
        val Regular_Thin: FontResource by lazy { FontResource("font/LCTPicon-Regular-Thin.ttf") }
        val Regular_ExtraLight: FontResource by lazy { FontResource("font/LCTPicon-Regular-ExtraLight.ttf") }
        val Regular_Light: FontResource by lazy { FontResource("font/LCTPicon-Regular-Light.ttf") }
        val Regular_Normal: FontResource by lazy { FontResource("font/LCTPicon-Regular-Normal.ttf") }
        val Regular_Medium: FontResource by lazy { FontResource("font/LCTPicon-Regular-Medium.ttf") }
        val Regular_SemiBold: FontResource by lazy { FontResource("font/LCTPicon-Regular-SemiBold.ttf") }
        val Regular_Bold: FontResource by lazy { FontResource("font/LCTPicon-Regular-Bold.ttf") }
        val Regular_ExtraBold: FontResource by lazy { FontResource("font/LCTPicon-Regular-ExtraBold.ttf") }
        val Regular_Black: FontResource by lazy { FontResource("font/LCTPicon-Regular-Black.ttf") }

        val Condensed_Thin: FontResource by lazy { FontResource("font/LCTPicon-Condensed-Thin.ttf") }
        val Condensed_ExtraLight: FontResource by lazy { FontResource("font/LCTPicon-Condensed-ExtraLight.ttf") }
        val Condensed_Light: FontResource by lazy { FontResource("font/LCTPicon-Condensed-Light.ttf") }
        val Condensed_Normal: FontResource by lazy { FontResource("font/LCTPicon-Condensed-Normal.ttf") }
        val Condensed_Medium: FontResource by lazy { FontResource("font/LCTPicon-Condensed-Medium.ttf") }
        val Condensed_SemiBold: FontResource by lazy { FontResource("font/LCTPicon-Condensed-SemiBold.ttf") }
        val Condensed_Bold: FontResource by lazy { FontResource("font/LCTPicon-Condensed-Bold.ttf") }
        val Condensed_ExtraBold: FontResource by lazy { FontResource("font/LCTPicon-Condensed-ExtraBold.ttf") }
        val Condensed_Black: FontResource by lazy { FontResource("font/LCTPicon-Condensed-Black.ttf") }

        val Extended_Thin: FontResource by lazy { FontResource("font/LCTPicon-Extended-Thin.ttf") }
        val Extended_ExtraLight: FontResource by lazy { FontResource("font/LCTPicon-Extended-ExtraLight.ttf") }
        val Extended_Light: FontResource by lazy { FontResource("font/LCTPicon-Extended-Light.ttf") }
        val Extended_Normal: FontResource by lazy { FontResource("font/LCTPicon-Extended-Normal.ttf") }
        val Extended_Medium: FontResource by lazy { FontResource("font/LCTPicon-Extended-Medium.ttf") }
        val Extended_SemiBold: FontResource by lazy { FontResource("font/LCTPicon-Extended-SemiBold.ttf") }
        val Extended_Bold: FontResource by lazy { FontResource("font/LCTPicon-Extended-Bold.ttf") }
        val Extended_ExtraBold: FontResource by lazy { FontResource("font/LCTPicon-Extended-ExtraBold.ttf") }
        val Extended_Black: FontResource by lazy { FontResource("font/LCTPicon-Extended-Black.ttf") }
    }

    public val Regular: FontFamily @Composable get() = FontFamily(
        Font(resource = Resources.Regular_Thin, weight = FontWeight.Thin),
        Font(resource = Resources.Regular_ExtraLight, weight = FontWeight.ExtraLight),
        Font(resource = Resources.Regular_Light, weight = FontWeight.Light),
        Font(resource = Resources.Regular_Normal, weight = FontWeight.Normal),
        Font(resource = Resources.Regular_Medium, weight = FontWeight.Medium),
        Font(resource = Resources.Regular_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Resources.Regular_Bold, weight = FontWeight.Bold),
        Font(resource = Resources.Regular_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Resources.Regular_Black, weight = FontWeight.Black),
    )

    public val Condensed: FontFamily @Composable get() = FontFamily(
        Font(resource = Resources.Condensed_Thin, weight = FontWeight.Thin),
        Font(resource = Resources.Condensed_ExtraLight, weight = FontWeight.ExtraLight),
        Font(resource = Resources.Condensed_Light, weight = FontWeight.Light),
        Font(resource = Resources.Condensed_Normal, weight = FontWeight.Normal),
        Font(resource = Resources.Condensed_Medium, weight = FontWeight.Medium),
        Font(resource = Resources.Condensed_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Resources.Condensed_Bold, weight = FontWeight.Bold),
        Font(resource = Resources.Condensed_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Resources.Condensed_Black, weight = FontWeight.Black),
    )

    public val Extended: FontFamily @Composable get() = FontFamily(
        Font(resource = Resources.Extended_Thin, weight = FontWeight.Thin),
        Font(resource = Resources.Extended_ExtraLight, weight = FontWeight.ExtraLight),
        Font(resource = Resources.Extended_Light, weight = FontWeight.Light),
        Font(resource = Resources.Extended_Normal, weight = FontWeight.Normal),
        Font(resource = Resources.Extended_Medium, weight = FontWeight.Medium),
        Font(resource = Resources.Extended_SemiBold, weight = FontWeight.SemiBold),
        Font(resource = Resources.Extended_Bold, weight = FontWeight.Bold),
        Font(resource = Resources.Extended_ExtraBold, weight = FontWeight.ExtraBold),
        Font(resource = Resources.Extended_Black, weight = FontWeight.Black),
    )

}