package net.kodein.theme.cup

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import net.kodein.theme.compose.m2.KodeinMaterialColors
import net.kodein.theme.compose.m2.kodeinMaterialShapes
import net.kodein.theme.compose.m2.kodeinMaterialTypography


// Linear scale down
// f(20) = 16
// f(96) = 32
private fun TextStyle.scaleDown() = copy(
    fontSize = ((fontSize.value * 0.2105263158) + 11.789473684).sp,
    lineHeight = ((lineHeight.value * 0.2105263158) + 11.789473684).sp,
)

@Composable
public fun KodeinCupMaterialTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = KodeinMaterialColors.dark().colors,
        typography = kodeinMaterialTypography().let {
            it.copy(
                h1 = it.h1.scaleDown(),
                h2 = it.h2.scaleDown(),
                h3 = it.h3.scaleDown(),
                h4 = it.h4.scaleDown(),
                h5 = it.h5.scaleDown(),
                h6 = it.h6.scaleDown(),
            )
        },
        shapes = kodeinMaterialShapes(),
        content = content,
    )
}
