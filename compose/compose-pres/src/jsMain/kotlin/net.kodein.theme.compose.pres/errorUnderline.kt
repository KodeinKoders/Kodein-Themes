package net.kodein.theme.compose.pres

import net.kodein.pres.sourcecode.SegmentAnimationBuilder
import net.kodein.pres.util.transition
import net.kodein.theme.compose.web.css
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.*
import org.w3c.dom.HTMLElement


public fun AttrsBuilder<out HTMLElement>.errorUnder(shown: Boolean = true) {
    css {
        position(Position.Relative)
        after {
            property("content", "\"\"")
            position(Position.Absolute)
            top(0.px)
            right(0.px)
            bottom(0.px)
            left(0.px)
            backgroundImage("url('img/red-u.png')")
            backgroundPosition("bottom")
            backgroundRepeat("repeat-x")
            backgroundSize("0.25em")
            transition { "opacity"(500.ms) }
            opacity(if (shown) 1 else 0)
        }
    }
}

public fun SegmentAnimationBuilder.errorUnder(shown: Boolean) {
    attrs {
        errorUnder(shown)
    }
}
