package net.kodein.theme.cup

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import net.kodein.cup.widgets.material3.cupScaleDown
import net.kodein.theme.compose.KodeinMaterial

@Composable
public fun KodeinCupMaterialTheme(
    isDark: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDark) KodeinMaterial.darkColorScheme else KodeinMaterial.lightColorScheme,
        typography = KodeinMaterial.typography.cupScaleDown(),
        shapes = KodeinMaterial.shapes,
        content = content,
    )
}
