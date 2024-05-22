package net.kodein.theme.cup

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import net.kodein.cup.widgets.material.cupScaleDown
import net.kodein.theme.compose.m2.KodeinMaterialColors
import net.kodein.theme.compose.m2.kodeinMaterialShapes
import net.kodein.theme.compose.m2.kodeinMaterialTypography


@Composable
public fun KodeinCupMaterialTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = KodeinMaterialColors.dark().colors,
        typography = kodeinMaterialTypography().cupScaleDown(),
        shapes = kodeinMaterialShapes(),
        content = content,
    )
}
