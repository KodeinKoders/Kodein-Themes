package net.kodein.theme.compose

import androidx.compose.ui.graphics.Color
import net.kodein.theme.KodeinColors


public fun Color(kc: KodeinColors.Color): Color =
    Color(0xFF_000000 or kc.rgb.toLong())
