package net.kodein.theme.cup

import androidx.compose.ui.graphics.Color
import org.kodein.pres.utils.DataMap
import org.kodein.pres.utils.DataMapElement


public data class KodeinPresentationBackground(
    val color: Color,
) : DataMapElement<KodeinPresentationBackground>(Key) {
    public companion object Key : DataMap.Key<KodeinPresentationBackground>
}
