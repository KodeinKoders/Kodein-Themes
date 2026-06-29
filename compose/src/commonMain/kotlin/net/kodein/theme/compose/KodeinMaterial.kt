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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.theme.KodeinColors


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
public object KodeinMaterial {

    public val lightColorScheme: ColorScheme = ColorScheme(
        primary = Color(KodeinColors.orange600),
        onPrimary = Color(KodeinColors.orange050),
        primaryContainer = Color(KodeinColors.orange300),
        onPrimaryContainer = Color(KodeinColors.purple600),
        inversePrimary = Color(KodeinColors.orange300),
//        secondary = Color(KodeinColors.purple500),
//        onSecondary = Color(KodeinColors.orange050),
//        secondaryContainer = Color(KodeinColors.purple100),
//        onSecondaryContainer = Color(KodeinColors.purple600),
//        tertiary = Color(KodeinColors.orange800).copy(),
//        onTertiary = Color(KodeinColors.orange050),
//        tertiaryContainer = Color(KodeinColors.orange250),
//        onTertiaryContainer = Color(KodeinColors.purple800),
        secondary = Color(KodeinColors.orange800).copy(),
        onSecondary = Color(KodeinColors.orange050),
        secondaryContainer = Color(KodeinColors.orange200),
        onSecondaryContainer = Color(KodeinColors.purple800),
        tertiary = Color(KodeinColors.purple500),
        onTertiary = Color(KodeinColors.orange050),
        tertiaryContainer = Color(KodeinColors.purple050),
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
        primaryFixed = Color(KodeinColors.orange300), // = light primaryContainer
        primaryFixedDim = Color(KodeinColors.orange400),
        onPrimaryFixed = Color(KodeinColors.purple600), // = light onPrimaryContainer
        onPrimaryFixedVariant = Color(KodeinColors.purple500),
        secondaryFixed = Color(KodeinColors.orange200), // = light secondaryContainer
        secondaryFixedDim = Color(KodeinColors.orange300),
        onSecondaryFixed = Color(KodeinColors.purple800), // = light onSecondaryContainer
        onSecondaryFixedVariant = Color(KodeinColors.purple600),
        tertiaryFixed = Color(KodeinColors.purple050), // = light tertiaryContainer
        tertiaryFixedDim = Color(KodeinColors.purple150),
        onTertiaryFixed = Color(KodeinColors.purple600), // = light onTertiaryContainer
        onTertiaryFixedVariant = Color(KodeinColors.purple500),
    )

    public val darkColorScheme: ColorScheme = ColorScheme(
        primary = Color(KodeinColors.orange300),
        onPrimary = Color(KodeinColors.purple600),
        primaryContainer = Color(KodeinColors.orange800),
        onPrimaryContainer = Color(KodeinColors.orange100),
        inversePrimary = Color(KodeinColors.orange900),
        secondary = Color(KodeinColors.orange100),
        onSecondary = Color(KodeinColors.orange800),
        secondaryContainer = Color(KodeinColors.orange950),
        onSecondaryContainer = Color(KodeinColors.orange200),
        tertiary = Color(KodeinColors.purple200),
        onTertiary = Color(KodeinColors.purple800),
        tertiaryContainer = Color(KodeinColors.purple600),
        onTertiaryContainer = Color(KodeinColors.purple100),
//        secondary = Color(KodeinColors.purple200),
//        onSecondary = Color(KodeinColors.purple800),
//        secondaryContainer = Color(KodeinColors.purple600),
//        onSecondaryContainer = Color(KodeinColors.orange100),
//        tertiary = Color(KodeinColors.orange100),
//        onTertiary = Color(KodeinColors.orange800),
//        tertiaryContainer = Color(KodeinColors.orange950),
//        onTertiaryContainer = Color(KodeinColors.orange100),
        background = Color(KodeinColors.purple800), // = surface
        onBackground = Color(KodeinColors.orange100), // = onSurface
        surface = Color(KodeinColors.purple800), // = background
        onSurface = Color(KodeinColors.orange100), // = onBackground
        surfaceVariant = Color(KodeinColors.orange950),
        onSurfaceVariant = Color(KodeinColors.orange300),
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
        secondaryFixed = Color(KodeinColors.purple200),
        secondaryFixedDim = Color(KodeinColors.purple250),
        onSecondaryFixed = Color(KodeinColors.purple800),
        onSecondaryFixedVariant = Color(KodeinColors.purple600),
        tertiaryFixed = Color(KodeinColors.orange150),
        tertiaryFixedDim = Color(KodeinColors.orange250),
        onTertiaryFixed = Color(KodeinColors.orange800),
        onTertiaryFixedVariant = Color(KodeinColors.orange600),
    )

    public val typography: Typography @Composable get() =
        Typography(
            displayLarge = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 57.sp,
                lineHeight = 57.sp * .80f,
            ),
            displayLargeEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 57.sp,
                lineHeight = 57.sp * .55f,
            ),
            displayMedium = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 45.sp,
                lineHeight = 45.sp * .80f,
            ),
            displayMediumEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 45.sp,
                lineHeight = 45.sp * .55f,
            ),
            displaySmall = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 36.sp,
                lineHeight = 36.sp * .80f,
            ),
            displaySmallEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 36.sp,
                lineHeight = 36.sp * .55f,
            ),
            headlineLarge = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 32.sp,
                lineHeight = 32.sp * .80f,
            ),
            headlineLargeEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 32.sp,
                lineHeight = 32.sp * .55f,
            ),
            headlineMedium = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 28.sp,
                lineHeight = 28.sp * .80f,
            ),
            headlineMediumEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 28.sp,
                lineHeight = 28.sp * .55f,
            ),
            headlineSmall = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp,
                lineHeight = 24.sp * .80f,
            ),
            headlineSmallEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp,
                lineHeight = 24.sp * .55f,
            ),
            titleLarge = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp,
                lineHeight = 22.sp * .80f,
            ),
            titleLargeEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 22.sp,
                lineHeight = 22.sp * .80f,
            ),
            titleMedium = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                lineHeight = 16.sp * .80f,
            ),
            titleMediumEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 16.sp,
                lineHeight = 16.sp * .80f,
            ),
            titleSmall = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                lineHeight = 14.sp * .80f,
            ),
            titleSmallEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Black,
                fontSize = 14.sp,
                lineHeight = 14.sp * .80f,
            ),
            bodyLarge = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
            ),
            bodyLargeEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 24.sp,
            ),
            bodyMedium = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            ),
            bodyMediumEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            ),
            bodySmall = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
            ),
            bodySmallEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
            ),
            labelLarge = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            ),
            labelLargeEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            ),
            labelMedium = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight = 16.sp,
            ),
            labelMediumEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                lineHeight = 16.sp,
            ),
            labelSmall = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.SemiBold,
                fontSize = 11.sp,
                lineHeight = 16.sp,
            ),
            labelSmallEmphasized = TextStyle(
                fontFamily = LCTPicon.Regular,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                lineHeight = 16.sp,
            ),
        )

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
