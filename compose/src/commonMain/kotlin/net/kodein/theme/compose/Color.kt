package net.kodein.theme.compose

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import net.kodein.theme.KodeinColors


public fun Color(kc: KodeinColors.Color): Color =
    Color(0xFF_000000 or kc.rgb.toLong())

public fun KodeinColor(c: Color): KodeinColors.Color =
    KodeinColors.Color(0xFFFFFF and c.toArgb())
