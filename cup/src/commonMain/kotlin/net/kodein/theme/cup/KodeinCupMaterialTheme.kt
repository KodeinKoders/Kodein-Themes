package net.kodein.theme.cup

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import net.kodein.cup.widgets.material3.cupScaleDown
import net.kodein.theme.compose.KodeinMaterialColors
import net.kodein.theme.compose.kodeinMaterialShapes
import net.kodein.theme.compose.kodeinMaterialTypography


@Composable
public fun KodeinCupMaterialTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = KodeinMaterialColors.dark().colorScheme,
        typography = kodeinMaterialTypography().cupScaleDown(),
        shapes = kodeinMaterialShapes(),
        content = content,
    )
}
