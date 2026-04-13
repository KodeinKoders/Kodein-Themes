package net.kodein.theme.compose

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.kodein.theme.KodeinColors
import kotlin.jvm.JvmInline


@JvmInline
public value class KodeinMaterialColors private constructor(public val colorScheme: ColorScheme) {

    public companion object {
        public fun light(): KodeinMaterialColors = KodeinMaterialColors(
            ColorScheme(
                primary = Color(KodeinColors.orange),
                onPrimary = Color(KodeinColors.light_purple),
                primaryContainer = Color(KodeinColors.orange_light),
                onPrimaryContainer = Color(KodeinColors.dark_purple),
                inversePrimary = Color(KodeinColors.dark_purple),
                secondary = Color(KodeinColors.purple),
                onSecondary = Color(KodeinColors.light_orange),
                secondaryContainer = Color(KodeinColors.purple_light),
                onSecondaryContainer = Color(KodeinColors.dark_orange),
                tertiary = Color.Unspecified,
                onTertiary = Color.Unspecified,
                tertiaryContainer = Color.Unspecified,
                onTertiaryContainer = Color.Unspecified,
                background = Color(KodeinColors.light),
                onBackground = Color(KodeinColors.darker),
                surface = Color(KodeinColors.light),
                onSurface = Color(KodeinColors.darker),
                surfaceVariant = Color(KodeinColors.lighter),
                onSurfaceVariant = Color(KodeinColors.darker),
                surfaceTint = Color(KodeinColors.orange),
                inverseSurface = Color(KodeinColors.darker),
                inverseOnSurface = Color(KodeinColors.light),
                error = Color(KodeinColors.error),
                onError = Color(KodeinColors.onError),
                errorContainer = Color(KodeinColors.error),
                onErrorContainer = Color(KodeinColors.onError),
                outline = Color(KodeinColors.dark_orange),
                outlineVariant = Color(KodeinColors.dark_purple),
                scrim = Color(KodeinColors.darker),
                surfaceBright = Color(KodeinColors.lighter),
                surfaceDim = Color(KodeinColors.light_purple),
                surfaceContainer = Color(KodeinColors.purple_light),
                surfaceContainerHigh = Color(KodeinColors.light_purple),
                surfaceContainerHighest = Color(KodeinColors.light),
                surfaceContainerLow = Color(KodeinColors.purple),
                surfaceContainerLowest = Color(KodeinColors.purple_dark),
                primaryFixed = Color(KodeinColors.orange),
                primaryFixedDim = Color.Unspecified,
                onPrimaryFixed = Color.Unspecified,
                onPrimaryFixedVariant = Color.Unspecified,
                secondaryFixed = Color(KodeinColors.purple),
                secondaryFixedDim = Color.Unspecified,
                onSecondaryFixed = Color.Unspecified,
                onSecondaryFixedVariant = Color.Unspecified,
                tertiaryFixed = Color.Unspecified,
                tertiaryFixedDim = Color.Unspecified,
                onTertiaryFixed = Color.Unspecified,
                onTertiaryFixedVariant = Color.Unspecified,
            )
        )

        public fun dark(): KodeinMaterialColors = KodeinMaterialColors(
            ColorScheme(
                primary = Color(KodeinColors.orange),
                onPrimary = Color(KodeinColors.dark_purple),
                primaryContainer = Color(KodeinColors.orange_dark),
                onPrimaryContainer = Color(KodeinColors.light_purple),
                inversePrimary = Color(KodeinColors.light_purple),
                secondary = Color(KodeinColors.purple),
                onSecondary = Color(KodeinColors.dark_orange),
                secondaryContainer = Color(KodeinColors.purple_dark),
                onSecondaryContainer = Color(KodeinColors.light_orange),
                tertiary = Color.Unspecified,
                onTertiary = Color.Unspecified,
                tertiaryContainer = Color.Unspecified,
                onTertiaryContainer = Color.Unspecified,
                background = Color(KodeinColors.dark),
                onBackground = Color(KodeinColors.light),
                surface = Color(KodeinColors.dark),
                onSurface = Color(KodeinColors.light),
                surfaceVariant = Color(KodeinColors.darker),
                onSurfaceVariant = Color(KodeinColors.light),
                surfaceTint = Color(KodeinColors.orange),
                inverseSurface = Color(KodeinColors.lighter),
                inverseOnSurface = Color(KodeinColors.dark),
                error = Color(KodeinColors.error),
                onError = Color(KodeinColors.onError),
                errorContainer = Color(KodeinColors.error),
                onErrorContainer = Color(KodeinColors.onError),
                outline = Color(KodeinColors.light_orange),
                outlineVariant = Color(KodeinColors.purple),
                scrim = Color(KodeinColors.darker),
                surfaceBright = Color(KodeinColors.dark_purple),
                surfaceDim = Color(KodeinColors.darker),
                surfaceContainer = Color(KodeinColors.purple_dark),
                surfaceContainerHigh = Color(KodeinColors.purple),
                surfaceContainerHighest = Color(KodeinColors.purple_light),
                surfaceContainerLow = Color(KodeinColors.dark),
                surfaceContainerLowest = Color(KodeinColors.darker),
                primaryFixed = Color(KodeinColors.orange),
                primaryFixedDim = Color.Unspecified,
                onPrimaryFixed = Color.Unspecified,
                onPrimaryFixedVariant = Color.Unspecified,
                secondaryFixed = Color(KodeinColors.purple),
                secondaryFixedDim = Color.Unspecified,
                onSecondaryFixed = Color.Unspecified,
                onSecondaryFixedVariant = Color.Unspecified,
                tertiaryFixed = Color.Unspecified,
                tertiaryFixedDim = Color.Unspecified,
                onTertiaryFixed = Color.Unspecified,
                onTertiaryFixedVariant = Color.Unspecified,
            )
        )
    }

}

@Composable
public fun kodeinMaterialTypography(): Typography {
    val default = Typography()
    return Typography(
        displayLarge = default.displayLarge.copy(fontFamily = LCTPicon.Extended),
        displayMedium = default.displayMedium.copy(fontFamily = LCTPicon.Extended),
        displaySmall = default.displaySmall.copy(fontFamily = LCTPicon.Extended),
        headlineLarge = default.headlineLarge.copy(fontFamily = LCTPicon.Extended),
        headlineMedium = default.headlineMedium.copy(fontFamily = LCTPicon.Extended),
        headlineSmall = default.headlineSmall.copy(fontFamily = LCTPicon.Extended),
        titleLarge = default.titleLarge.copy(fontFamily = LCTPicon.Regular),
        titleMedium = default.titleMedium.copy(fontFamily = LCTPicon.Regular),
        titleSmall = default.titleSmall.copy(fontFamily = LCTPicon.Regular),
        bodyLarge = default.bodyLarge.copy(fontFamily = LCTPicon.Regular),
        bodyMedium = default.bodyMedium.copy(fontFamily = LCTPicon.Regular),
        bodySmall = default.bodySmall.copy(fontFamily = LCTPicon.Regular),
        labelLarge = default.labelLarge.copy(fontFamily = LCTPicon.Regular),
        labelMedium = default.labelMedium.copy(fontFamily = LCTPicon.Regular),
        labelSmall = default.labelSmall.copy(fontFamily = LCTPicon.Regular),
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
public fun kodeinMaterialShapes(): Shapes =
    Shapes(
        extraSmall = CutCornerShape(4.dp),
        small = CutCornerShape(8.dp),
        medium = CutCornerShape(12.dp),
        large = CutCornerShape(16.dp),
        extraLarge = CutCornerShape(28.dp),
        largeIncreased = CutCornerShape(20.dp),
        extraLargeIncreased = CutCornerShape(32.dp),
        extraExtraLarge = CutCornerShape(48.dp),
    )


@Composable
public fun KodeinMaterialTheme(
    colors: KodeinMaterialColors,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colors.colorScheme,
        typography = kodeinMaterialTypography(),
        shapes = kodeinMaterialShapes(),
        content = content,
    )
}
