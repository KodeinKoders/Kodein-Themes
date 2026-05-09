package net.kodein.theme.cup

import androidx.compose.ui.graphics.Color
import net.kodein.cup.utils.SlideContext
import net.kodein.cup.utils.SlideContextElement


public data class KodeinPresentationBackground(
    val color: Color,
) : SlideContextElement<KodeinPresentationBackground>(Key) {
    public companion object Key : SlideContext.Key<KodeinPresentationBackground>
}
