package net.kodein.theme.compose.pres

import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.backgroundPosition
import org.jetbrains.compose.web.css.backgroundRepeat
import org.jetbrains.compose.web.css.backgroundSize
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.opacity
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.transitions
import org.kodein.compose.html.css.css
import org.kodein.compose.html.pres.sourcecode.SegmentAnimationBuilder
import org.w3c.dom.HTMLElement


public fun AttrsScope<HTMLElement>.errorUnder(shown: Boolean = true) {
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
            transitions { "opacity" { duration = 500.ms } }
            opacity(if (shown) 1 else 0)
        }
    }
}

public fun SegmentAnimationBuilder.errorUnder(shown: Boolean) {
    attrs {
        errorUnder(shown)
    }
}
