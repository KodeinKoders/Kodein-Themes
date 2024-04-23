package net.kodein.theme.cup

import androidx.compose.ui.graphics.Color
import net.kodein.cup.utils.DataMap
import net.kodein.cup.utils.DataMapElement


public data class KodeinPresentationBackground(
    val color: Color,
) : DataMapElement<KodeinPresentationBackground>(Key) {
    public companion object Key : DataMap.Key<KodeinPresentationBackground>
}
