package net.kodein.theme.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.kodein.theme.KodeinColors


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
public object KodeinMaterial {

    public val lightColorScheme: ColorScheme = ColorScheme(
        primary = Color(KodeinColors.orange600),
        onPrimary = Color(KodeinColors.orange050),
        primaryContainer = Color(KodeinColors.orange300),
        onPrimaryContainer = Color(KodeinColors.purple600),
        inversePrimary = Color(KodeinColors.orange300),
        secondary = Color(KodeinColors.orange800).copy(),
        onSecondary = Color(KodeinColors.orange050),
        secondaryContainer = Color(KodeinColors.orange250),
        onSecondaryContainer = Color(KodeinColors.purple800),
        tertiary = Color(KodeinColors.purple500),
        onTertiary = Color(KodeinColors.orange050),
        tertiaryContainer = Color(KodeinColors.purple100),
        onTertiaryContainer = Color(KodeinColors.purple600),
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
        surfaceBright = Color(KodeinColors.orange100), // = surface
        surfaceDim = Color(KodeinColors.orange200),
        surfaceContainer = Color(KodeinColors.orange175),
        surfaceContainerHigh = Color(KodeinColors.orange200),
        surfaceContainerHighest = Color(KodeinColors.orange225),
        surfaceContainerLow = Color(KodeinColors.orange150),
        surfaceContainerLowest = Color(KodeinColors.orange125),
        primaryFixed = Color(KodeinColors.orange200),
        primaryFixedDim = Color(KodeinColors.orange300),
        onPrimaryFixed = Color(KodeinColors.purple600),
        onPrimaryFixedVariant = Color(KodeinColors.purple500),
        secondaryFixed = Color(KodeinColors.orange150),
        secondaryFixedDim = Color(KodeinColors.orange250),
        onSecondaryFixed = Color(KodeinColors.purple800),
        onSecondaryFixedVariant = Color(KodeinColors.purple600),
        tertiaryFixed = Color(KodeinColors.purple200),
        tertiaryFixedDim = Color(KodeinColors.purple250),
        onTertiaryFixed = Color(KodeinColors.purple800),
        onTertiaryFixedVariant = Color(KodeinColors.purple600),
    )

    public val darkColorScheme: ColorScheme = ColorScheme(
        primary = Color(KodeinColors.orange300),
        onPrimary = Color(KodeinColors.purple600),
        primaryContainer = Color(KodeinColors.orange800),
        onPrimaryContainer = Color(KodeinColors.orange100),
        inversePrimary = Color(KodeinColors.orange900),
//        secondary = Color(KodeinColors.orange100),
//        onSecondary = Color(KodeinColors.orange800),
//        secondaryContainer = Color(KodeinColors.orange950),
//        onSecondaryContainer = Color(KodeinColors.orange200),
//        tertiary = Color(KodeinColors.purple200),
//        onTertiary = Color(KodeinColors.purple800),
//        tertiaryContainer = Color(KodeinColors.purple600),
//        onTertiaryContainer = Color(KodeinColors.purple100),
        secondary = Color(KodeinColors.purple200),
        onSecondary = Color(KodeinColors.purple800),
        secondaryContainer = Color(KodeinColors.purple600),
        onSecondaryContainer = Color(KodeinColors.orange100),
        tertiary = Color(KodeinColors.orange100),
        onTertiary = Color(KodeinColors.orange800),
        tertiaryContainer = Color(KodeinColors.orange950),
        onTertiaryContainer = Color(KodeinColors.orange100),
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
        outline = Color(KodeinColors.purple300),
        outlineVariant = Color(KodeinColors.purple550),
        scrim = Color(KodeinColors.purple950),
        surfaceBright = Color(KodeinColors.purple600),
        surfaceDim = Color(KodeinColors.purple800),
        surfaceContainer = Color(KodeinColors.purple700),
        surfaceContainerHigh = Color(KodeinColors.purple650),
        surfaceContainerHighest = Color(KodeinColors.purple600),
        surfaceContainerLow = Color(KodeinColors.purple750),
        surfaceContainerLowest = Color(KodeinColors.purple850),
        primaryFixed = Color(KodeinColors.orange200),
        primaryFixedDim = Color(KodeinColors.orange300),
        onPrimaryFixed = Color(KodeinColors.purple600),
        onPrimaryFixedVariant = Color(KodeinColors.purple500),
//        secondaryFixed = Color(KodeinColors.orange150),
//        secondaryFixedDim = Color(KodeinColors.orange250),
//        onSecondaryFixed = Color(KodeinColors.purple800),
//        onSecondaryFixedVariant = Color(KodeinColors.purple600),
//        tertiaryFixed = Color(KodeinColors.purple200),
//        tertiaryFixedDim = Color(KodeinColors.purple250),
//        onTertiaryFixed = Color(KodeinColors.purple800),
//        onTertiaryFixedVariant = Color(KodeinColors.purple600),
        secondaryFixed = Color(KodeinColors.purple200),
        secondaryFixedDim = Color(KodeinColors.purple250),
        onSecondaryFixed = Color(KodeinColors.purple800),
        onSecondaryFixedVariant = Color(KodeinColors.purple600),
        tertiaryFixed = Color(KodeinColors.orange150),
        tertiaryFixedDim = Color(KodeinColors.orange250),
        onTertiaryFixed = Color(KodeinColors.purple800),
        onTertiaryFixedVariant = Color(KodeinColors.purple600),
    )

    public val typography: Typography @Composable get() = Typography().let { default ->
        Typography(
            displayLarge = default.displayLarge.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            displayMedium = default.displayMedium.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            displaySmall = default.displaySmall.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            headlineLarge = default.headlineLarge.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            headlineMedium = default.headlineMedium.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            headlineSmall = default.headlineSmall.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            titleLarge = default.titleLarge.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            titleMedium = default.titleMedium.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            titleSmall = default.titleSmall.copy(fontFamily = LCTPicon.Regular, fontWeight = FontWeight.Black),
            bodyLarge = default.bodyLarge.copy(fontFamily = LCTPicon.Regular),
            bodyMedium = default.bodyMedium.copy(fontFamily = LCTPicon.Regular),
            bodySmall = default.bodySmall.copy(fontFamily = LCTPicon.Regular),
            labelLarge = default.labelLarge.copy(fontFamily = LCTPicon.Regular),
            labelMedium = default.labelMedium.copy(fontFamily = LCTPicon.Regular),
            labelSmall = default.labelSmall.copy(fontFamily = LCTPicon.Regular),
        )
    }

    public val shapes: Shapes = Shapes(
        extraSmall = RoundedCornerShape(8.dp),
        small = RoundedCornerShape(16.dp),
        medium = RoundedCornerShape(24.dp),
        large = RoundedCornerShape(32.dp),
        extraLarge = RoundedCornerShape(56.dp),
        largeIncreased = RoundedCornerShape(40.dp),
        extraLargeIncreased = RoundedCornerShape(64.dp),
        extraExtraLarge = RoundedCornerShape(96.dp),
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
