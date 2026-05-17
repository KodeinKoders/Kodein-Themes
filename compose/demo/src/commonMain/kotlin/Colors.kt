import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.GridTrackSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.KodeinColor
import kotlin.math.roundToInt


@OptIn(ExperimentalGridApi::class)
@Composable
fun Colors(
    isDark: Boolean,
) {
    val colors = MaterialTheme.colorScheme

    Grid(
        config = {
            gap(4.dp)

            column(size = 256.dp)
            column(size = 256.dp)
            column(size = 256.dp)
            column(size = 4.dp)
            column(size = 256.dp)

            row(GridTrackSize.Auto)
        },
    ) {
        // First row
        ColorDisplay(
            name = "Primary",
            color = colors.primary,
            onColor = colors.onPrimary,
        )
        ColorDisplay(
            name = "Secondary",
            color = colors.secondary,
            onColor = colors.onSecondary,
        )
        ColorDisplay(
            name = "Tertiary",
            color = colors.tertiary,
            onColor = colors.onTertiary,
        )
        Spacer(Modifier)
        ColorDisplay(
            name = "Error",
            color = colors.error,
            onColor = colors.onError,
        )

        // Second row
        ColorDisplay(
            name = "Primary Container",
            color = colors.primaryContainer,
            onColor = colors.onPrimaryContainer,
        )
        ColorDisplay(
            name = "Secondary Container",
            color = colors.secondaryContainer,
            onColor = colors.onSecondaryContainer,
        )
        ColorDisplay(
            name = "Tertiary Container",
            color = colors.tertiaryContainer,
            onColor = colors.onTertiaryContainer,
        )
        Spacer(Modifier)
        ColorDisplay(
            name = "Error Container",
            color = colors.errorContainer,
            onColor = colors.onErrorContainer,
        )

        // Third row
        ColorDisplay(
            name = "Primary Fixed",
            color = colors.primaryFixed,
            onColor = colors.onPrimaryFixed,
            colorDim = colors.primaryFixedDim,
            onColorVariant = colors.onPrimaryFixedVariant,
        )
        ColorDisplay(
            name = "Secondary Fixed",
            color = colors.secondaryFixed,
            onColor = colors.onSecondaryFixed,
            colorDim = colors.secondaryFixedDim,
            onColorVariant = colors.onSecondaryFixedVariant,
        )
        ColorDisplay(
            name = "Tertiary Fixed",
            color = colors.tertiaryFixed,
            onColor = colors.onTertiaryFixed,
            colorDim = colors.tertiaryFixedDim,
            onColorVariant = colors.onTertiaryFixedVariant,
        )
        Spacer(Modifier)
        Spacer(Modifier)

        // Fourth row
        ColorDisplay(
            name = "Surface",
            color = colors.surface,
            colorDim = colors.surfaceDim,
            colorBright = colors.surfaceBright,
            onColor = colors.onSurface,
            modifier = Modifier.gridItem(columnSpan = 2)
        )
        ColorDisplay(
            name = "Surface Variant",
            color = colors.surfaceVariant,
            onColor = colors.onSurfaceVariant,
        )
        Spacer(Modifier)
        Column (
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.gridItem(rowSpan = 2)
        ) {
            ColorDisplay(
                name = "Inverse Surface",
                color = colors.inverseSurface,
                onColor = colors.inverseOnSurface,
                modifier = Modifier.fillMaxWidth()
            )
            ProvideTextStyle(TextStyle(color = colors.primary)) {
                ColorDisplay(
                    name = "Inverse Primary",
                    color = colors.inversePrimary,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Fifth row
        Row(
            modifier = Modifier.gridItem(columnSpan = 3)
        ) {
            ProvideTextStyle(TextStyle(color = colors.onSurface)) {
                ColorDisplay(
                    name = "Surface Container Lowest",
                    color = colors.surfaceContainerLowest,
                    modifier = Modifier.weight(1f)
                )
                ColorDisplay(
                    name = "Surface Container Low",
                    color = colors.surfaceContainerLow,
                    modifier = Modifier.weight(1f)
                )
                ColorDisplay(
                    name = "Surface Container",
                    color = colors.surfaceContainer,
                    modifier = Modifier.weight(1f)
                )
                ColorDisplay(
                    name = "Surface Container High",
                    color = colors.surfaceContainerHigh,
                    modifier = Modifier.weight(1f)
                )
                ColorDisplay(
                    name = "Surface Container Highest",
                    color = colors.surfaceContainerHighest,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Spacer(Modifier)

        // Sixth row
        ProvideTextStyle(TextStyle(color = colors.surface)) {
            ColorDisplay(
                name = "Outline",
                color = colors.outline,
            )
        }
        ProvideTextStyle(TextStyle(color = colors.onSurface)) {
            ColorDisplay(
                name = "Outline Variant",
                color = colors.outlineVariant,
            )
        }
        ProvideTextStyle(TextStyle(color = if (isDark) colors.onSurface else colors.surface)) {
            ColorDisplay(
                name = "Scrim",
                color = colors.scrim,
            )
        }
    }
}

@Composable
private fun ColorDisplay(
    name: String,
    color: Color,
    onColor: Color = Color.Unspecified,
    colorDim: Color = Color.Unspecified,
    colorBright: Color = Color.Unspecified,
    onColorVariant: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(64.dp)
        ) {
            if (colorBright != Color.Unspecified) {
                NameAndColor(
                    name = "$name Bright",
                    color = colorBright,
                    onColor = onColor,
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                )
            }
            NameAndColor(
                name = name,
                color = color,
                onColor = onColor,
                modifier = Modifier.weight(1f).fillMaxHeight(),
            )
            if (colorDim != Color.Unspecified) {
                NameAndColor(
                    name = "$name Dim",
                    color = colorDim,
                    onColor = onColor,
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                )
            }
        }
        if (onColor != Color.Unspecified) {
            NameAndColor(
                name = "On $name",
                color = onColor,
                onColor = color,
                modifier = Modifier.fillMaxWidth().height(48.dp)
            )
        }
        if (onColorVariant != Color.Unspecified) {
            NameAndColor(
                name = "On $name Variant",
                color = onColorVariant,
                onColor = color,
                modifier = Modifier.fillMaxWidth().height(48.dp)
            )
        }
    }
}

@Composable
private fun NameAndColor(name: String, color: Color, onColor: Color, modifier: Modifier = Modifier) {
    Surface(
        color = color,
        contentColor = onColor,
        modifier = modifier
    ) {
        val colorName = KodeinColors.nameOf(KodeinColor(color))
        Text(
            text = buildAnnotatedString {
                append(name)
                withStyle(style = SpanStyle(fontSize = .85.em)) {
                    append("\n")
                    if (colorName != null) {
                        append("$colorName - ")
                    }
                    append("#${color.toHexString()}")
                }
            },
            lineHeight = .8.em,
            softWrap = true,
            modifier = Modifier.padding(8.dp)
        )
    }
}

private fun Color.toHexString(): String =
//    (alpha * 255).roundToInt().coerceIn(0, 255).toString(16).padStart(2, '0').uppercase() +
    (red * 255).roundToInt().coerceIn(0, 255).toString(16).padStart(2, '0').uppercase() +
            (green * 255).roundToInt().coerceIn(0, 255).toString(16).padStart(2, '0').uppercase() +
            (blue * 255).roundToInt().coerceIn(0, 255).toString(16).padStart(2, '0').uppercase()
