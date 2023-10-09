package net.kodein.theme.compose.pres

import net.kodein.theme.compose.web.Logo
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.alignSelf
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text
import org.kodein.compose.html.css.css
import org.kodein.compose.html.pres.Slide
import org.kodein.compose.html.pres.Transitions
import org.kodein.compose.html.pres.shownIf


public val kodeinKodersSlide: Slide = Slide(
    name = "kodein-koders",
    stateCount = 2
) { state ->
    Div({
        css {
            fontSize(4.em)
        }
    }) {
        Logo(
            catchPhrase = { Text("painless mobile technology") },
            section = { Text("Koders") }
        )
    }

    Img(
        src = "img/kotlin-certified-trainer.svg",
        alt = "Kotlin Trainer, certified by Jetbrains"
    ) {
        shownIf(state >= 1, Transitions.Stamp())
        css {
            height(5.em)
            padding(2.em)
            marginBottom((-5).em)
            alignSelf(AlignSelf.End)
        }
    }
}