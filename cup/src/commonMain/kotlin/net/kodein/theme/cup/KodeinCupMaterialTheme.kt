package net.kodein.theme.cup

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import net.kodein.cup.widgets.material3.cupScaleDown
import net.kodein.theme.compose.KodeinMaterial


@Composable
public fun KodeinCupMaterialTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = KodeinMaterial.darkColorScheme,
        typography = KodeinMaterial.typography.cupScaleDown(),
        shapes = KodeinMaterial.shapes,
        content = content,
    )
}
