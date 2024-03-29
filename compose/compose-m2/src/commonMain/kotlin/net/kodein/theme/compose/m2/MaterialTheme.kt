package net.kodein.theme.compose.m2

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.theme.KodeinColors
import net.kodein.theme.KodeinTexts
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.LCTPicon
import kotlin.jvm.JvmInline


@JvmInline
public value class KodeinMaterialColors private constructor(public val colors: Colors) {

    public companion object {
        public fun light(): KodeinMaterialColors = KodeinMaterialColors(Colors(
            primary = Color(KodeinColors.orange),
            primaryVariant =  Color(KodeinColors.orange_dark),
            secondary = Color(KodeinColors.purple),
            secondaryVariant = Color(KodeinColors.purple_dark),
            background = Color(KodeinColors.light),
            surface = Color(KodeinColors.light),
            error = Color(KodeinColors.dark_orange),
            onPrimary = Color(KodeinColors.light_purple),
            onSecondary = Color(KodeinColors.light_orange),
            onBackground = Color(KodeinColors.darker),
            onSurface = Color(KodeinColors.darker),
            onError = Color(KodeinColors.orange_light),
            isLight = true
        ))

        public fun dark(): KodeinMaterialColors = KodeinMaterialColors(Colors(
            primary = Color(KodeinColors.orange),
            primaryVariant =  Color(KodeinColors.orange_light),
            secondary = Color(KodeinColors.purple),
            secondaryVariant = Color(KodeinColors.purple_light),
            background = Color(KodeinColors.dark),
            surface = Color(KodeinColors.dark),
            error = Color(KodeinColors.light_orange),
            onPrimary = Color(KodeinColors.dark_purple),
            onSecondary = Color(KodeinColors.dark_orange),
            onBackground = Color(KodeinColors.light),
            onSurface = Color(KodeinColors.light),
            onError = Color(KodeinColors.orange_dark),
            isLight = false
        ))
    }

}

private val KodeinTexts.FontFamily.compose @Composable get() =
    when (name) {
        "LCTPicon-Regular" -> LCTPicon.Regular
        "LCTPicon-Extended" -> LCTPicon.Extended
        "LCTPicon-Condensed" -> LCTPicon.Condensed
        else -> error("Unknown font $name")
    }


private val KodeinTexts.FontWeight.compose @Composable get() = when (this) {
    KodeinTexts.FontWeight.Medium -> FontWeight.Medium
    KodeinTexts.FontWeight.Normal -> FontWeight.Normal
    KodeinTexts.FontWeight.Light -> FontWeight.Light
}

@Composable
private fun TextStyle.copyWith(style: KodeinTexts.Style) = copy(
    fontFamily = style.fontFamily.compose,
    fontWeight = style.fontWeight.compose,
    fontSize = style.fontSize.sp,
    lineHeight = style.lineHeight.sp,
    letterSpacing = style.letterSpacing.sp
)

@Composable
public fun kodeinMaterialTypography(): Typography {
    val default = Typography()
    return Typography(
        h1 = default.h1.copyWith(KodeinTexts.Styles.h1),
        h2 = default.h2.copyWith(KodeinTexts.Styles.h2),
        h3 = default.h3.copyWith(KodeinTexts.Styles.h3),
        h4 = default.h4.copyWith(KodeinTexts.Styles.h4),
        h5 = default.h5.copyWith(KodeinTexts.Styles.h5),
        h6 = default.h6.copyWith(KodeinTexts.Styles.h6),
        subtitle1 = default.subtitle1.copyWith(KodeinTexts.Styles.subtitle1),
        subtitle2 = default.subtitle2.copyWith(KodeinTexts.Styles.subtitle2),
        body1 = default.body1.copyWith(KodeinTexts.Styles.body1),
        body2 = default.body2.copyWith(KodeinTexts.Styles.body2),
        button = default.button.copyWith(KodeinTexts.Styles.button),
        caption = default.caption.copyWith(KodeinTexts.Styles.caption),
        overline = default.overline.copyWith(KodeinTexts.Styles.overline),
    )
}

public fun kodeinMaterialShapes(): Shapes =
    Shapes(
        small = CutCornerShape(4.dp),
        medium = CutCornerShape(4.dp),
        large = CutCornerShape(0.dp)
    )


@Composable
public fun KodeinMaterialTheme(
    colors: KodeinMaterialColors,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = colors.colors,
        typography = kodeinMaterialTypography(),
        shapes = kodeinMaterialShapes(),
        content = content,
    )
}
