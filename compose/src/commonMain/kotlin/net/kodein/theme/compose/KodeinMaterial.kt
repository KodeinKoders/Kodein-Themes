package net.kodein.theme.compose

import androidx.compose.foundation.isSystemInDarkTheme
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


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
public object KodeinMaterial {

    public val lightColorScheme: ColorScheme = ColorScheme(
        primary = Color(KodeinColors.orange600),
        onPrimary = Color(KodeinColors.orange100),
        primaryContainer = Color(KodeinColors.orange300),
        onPrimaryContainer = Color(KodeinColors.purple600),
        inversePrimary = Color(KodeinColors.orange050),
        secondary = Color(KodeinColors.purple500),
        onSecondary = Color(KodeinColors.orange100),
        secondaryContainer = Color(KodeinColors.purple100),
        onSecondaryContainer = Color(KodeinColors.purple600),
        tertiary = Color(KodeinColors.orange950),
        onTertiary = Color(KodeinColors.orange200),
        tertiaryContainer = Color(KodeinColors.orange800),
        onTertiaryContainer = Color(KodeinColors.orange100),
        background = Color(KodeinColors.orange100), // = surface
        onBackground = Color(KodeinColors.purple600), // = onSurface
        surface = Color(KodeinColors.orange100), // = background
        onSurface = Color(KodeinColors.purple600), // = onBackground
        surfaceVariant = Color(KodeinColors.purple100),
        onSurfaceVariant = Color(KodeinColors.purple600),
        surfaceTint = Color(KodeinColors.purple600), // = primary
        inverseSurface = Color(KodeinColors.orange900),
        inverseOnSurface = Color(KodeinColors.orange100),
        error = Color(0xFF_C00000),
        onError = Color(0xFF_FFFFFF),
        errorContainer = Color(0xFF_FFA0A0),
        onErrorContainer = Color(0xFF_300000),
        outline = Color(KodeinColors.purple600),
        outlineVariant = Color(KodeinColors.purple200),
        scrim = Color(KodeinColors.purple800),
        surfaceBright = Color(KodeinColors.orange100),
        surfaceDim = Color(KodeinColors.orange200),
        surfaceContainer = Color(KodeinColors.orange200),
        surfaceContainerHigh = Color(KodeinColors.orange300),
        surfaceContainerHighest = Color(KodeinColors.orange400),
        surfaceContainerLow = Color(KodeinColors.orange100),
        surfaceContainerLowest = Color(KodeinColors.orange050),
        primaryFixed = Color(KodeinColors.orange200),
        primaryFixedDim = Color(KodeinColors.orange300),
        onPrimaryFixed = Color(KodeinColors.purple600),
        onPrimaryFixedVariant = Color(KodeinColors.purple500),
        secondaryFixed = Color(KodeinColors.purple200),
        secondaryFixedDim = Color(KodeinColors.purple300),
        onSecondaryFixed = Color(KodeinColors.purple800),
        onSecondaryFixedVariant = Color(KodeinColors.purple600),
        tertiaryFixed = Color(KodeinColors.orange400),
        tertiaryFixedDim = Color(KodeinColors.orange500),
        onTertiaryFixed = Color(KodeinColors.purple800),
        onTertiaryFixedVariant = Color(KodeinColors.purple600),
    )

    public val darkColorScheme: ColorScheme = ColorScheme(
        primary = Color(KodeinColors.orange300),
        onPrimary = Color(KodeinColors.purple600),
        primaryContainer = Color(KodeinColors.orange800),
        onPrimaryContainer = Color(KodeinColors.orange100),
        inversePrimary = Color(KodeinColors.orange900),
        secondary = Color(KodeinColors.purple200),
        onSecondary = Color(KodeinColors.purple800),
        secondaryContainer = Color(KodeinColors.purple600),
        onSecondaryContainer = Color(KodeinColors.purple100),
        tertiary = Color(KodeinColors.orange100),
        onTertiary = Color(KodeinColors.orange800),
        tertiaryContainer = Color(KodeinColors.orange950),
        onTertiaryContainer = Color(KodeinColors.orange200),
        background = Color(KodeinColors.purple800), // = surface
        onBackground = Color(KodeinColors.orange100), // = onSurface
        surface = Color(KodeinColors.purple800), // = background
        onSurface = Color(KodeinColors.orange100), // = onBackground
        surfaceVariant = Color(KodeinColors.orange950),
        onSurfaceVariant = Color(KodeinColors.purple100),
        surfaceTint = Color(KodeinColors.orange300), // = primary
        inverseSurface = Color(KodeinColors.purple100),
        inverseOnSurface = Color(KodeinColors.purple600),
        error = Color(0xFF_FFC0C0),
        onError = Color(0xFF_800000),
        errorContainer = Color(0xFF_C00000),
        onErrorContainer = Color(0xFF_FFE0E0),
        outline = Color(KodeinColors.orange100),
        outlineVariant = Color(KodeinColors.orange800),
        scrim = Color(KodeinColors.purple800),
        surfaceBright = Color(KodeinColors.purple600),
        surfaceDim = Color(KodeinColors.purple800),
        surfaceContainer = Color(KodeinColors.purple600),
        surfaceContainerHigh = Color(KodeinColors.purple500),
        surfaceContainerHighest = Color(KodeinColors.purple400),
        surfaceContainerLow = Color(KodeinColors.purple700),
        surfaceContainerLowest = Color(KodeinColors.purple900),
        primaryFixed = Color(KodeinColors.orange200),
        primaryFixedDim = Color(KodeinColors.orange300),
        onPrimaryFixed = Color(KodeinColors.purple600),
        onPrimaryFixedVariant = Color(KodeinColors.purple500),
        secondaryFixed = Color(KodeinColors.purple200),
        secondaryFixedDim = Color(KodeinColors.purple300),
        onSecondaryFixed = Color(KodeinColors.purple800),
        onSecondaryFixedVariant = Color(KodeinColors.purple600),
        tertiaryFixed = Color(KodeinColors.orange400),
        tertiaryFixedDim = Color(KodeinColors.orange500),
        onTertiaryFixed = Color(KodeinColors.purple800),
        onTertiaryFixedVariant = Color(KodeinColors.purple600),
    )

    public val typography: Typography @Composable get() = Typography().let { default ->
        Typography(
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

    public val shapes: Shapes = Shapes(
        extraSmall = CutCornerShape(4.dp),
        small = CutCornerShape(8.dp),
        medium = CutCornerShape(12.dp),
        large = CutCornerShape(16.dp),
        extraLarge = CutCornerShape(28.dp),
        largeIncreased = CutCornerShape(20.dp),
        extraLargeIncreased = CutCornerShape(32.dp),
        extraExtraLarge = CutCornerShape(48.dp),
    )
}

@Composable
public fun KodeinMaterialTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDark) KodeinMaterial.darkColorScheme else KodeinMaterial.lightColorScheme,
        typography = KodeinMaterial.typography,
        shapes = KodeinMaterial.shapes,
        content = content,
    )
}
