package net.kodein.theme

import net.kodein.theme.utils.ValueHolder
import kotlin.jvm.JvmInline


public object KodeinTexts {
    @JvmInline
    public value class FontFamily(public val name: String)

    public object FontFamilies : ValueHolder<FontFamilies, FontFamily>() {
        public val regular: FontFamily by FontFamily("LCTPicon-Regular")
        public val extended: FontFamily by FontFamily("LCTPicon-Extended")
        public val condensed: FontFamily by FontFamily("LCTPicon-Condensed")
    }

    public enum class FontWeight { Medium, Normal, Light }

    public class Style(
        public val fontFamily: FontFamily,
        public val fontWeight: FontWeight,
        public val fontSize: Int,
        public val lineHeight: Int,
        public val letterSpacing: Float
    )

    public object Styles : ValueHolder<Styles, Style>() {
        public val h1: Style by Style(
            fontFamily = FontFamilies.extended,
            fontWeight = FontWeight.Light,
            fontSize = 96,
            lineHeight = 112,
            letterSpacing = -1.5f,
        )
        public val h2: Style by Style(
            fontFamily = FontFamilies.extended,
            fontWeight = FontWeight.Light,
            fontSize = 60,
            lineHeight = 72,
            letterSpacing = -0.5f,
        )
        public val h3: Style by Style(
            fontFamily = FontFamilies.extended,
            fontWeight = FontWeight.Normal,
            fontSize = 48,
            lineHeight = 56,
            letterSpacing = 0f,
        )
        public val h4: Style by Style(
            fontFamily = FontFamilies.extended,
            fontWeight = FontWeight.Normal,
            fontSize = 34,
            lineHeight = 36,
            letterSpacing = 0.25f,
        )
        public val h5: Style by Style(
            fontFamily = FontFamilies.extended,
            fontWeight = FontWeight.Normal,
            fontSize = 24,
            lineHeight = 24,
            letterSpacing = 0f,
        )
        public val h6: Style by Style(
            fontFamily = FontFamilies.extended,
            fontWeight = FontWeight.Medium,
            fontSize = 20,
            lineHeight = 24,
            letterSpacing = 0.15f,
        )
        public val subtitle1: Style by Style(
            fontFamily = FontFamilies.regular,
            fontWeight = FontWeight.Normal,
            fontSize = 16,
            lineHeight = 24,
            letterSpacing = 0.15f,
        )
        public val subtitle2: Style by Style(
            fontFamily = FontFamilies.regular,
            fontWeight = FontWeight.Medium,
            fontSize = 14,
            lineHeight = 24,
            letterSpacing = 0.1f,
        )
        public val body1: Style by Style(
            fontFamily = FontFamilies.regular,
            fontWeight = FontWeight.Normal,
            fontSize = 16,
            lineHeight = 24,
            letterSpacing = 0.5f,
        )
        public val body2: Style by Style(
            fontFamily = FontFamilies.regular,
            fontWeight = FontWeight.Normal,
            fontSize = 14,
            lineHeight = 20,
            letterSpacing = 0.025f,
        )
        public val button: Style by Style(
            fontFamily = FontFamilies.regular,
            fontWeight = FontWeight.Medium,
            fontSize = 14,
            lineHeight = 16,
            letterSpacing = 1.25f,
        )
        public val caption: Style by Style(
            fontFamily = FontFamilies.regular,
            fontWeight = FontWeight.Normal,
            fontSize = 12,
            lineHeight = 16,
            letterSpacing = 0.4f,
        )
        public val overline: Style by Style(
            fontFamily = FontFamilies.regular,
            fontWeight = FontWeight.Normal,
            fontSize = 10,
            lineHeight = 16,
            letterSpacing = 1.5f,
        )
    }
}
