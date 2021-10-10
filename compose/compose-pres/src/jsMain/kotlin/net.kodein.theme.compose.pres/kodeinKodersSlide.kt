package net.kodein.theme.compose.pres

import net.kodein.pres.Animations
import net.kodein.pres.Slide
import net.kodein.pres.Transitions
import net.kodein.pres.shownIf
import net.kodein.theme.compose.web.Logo
import net.kodein.theme.compose.web.css
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text
import kotlin.time.Duration


public fun kodeinKodersSlide(
    outFlip: Boolean = true
): Slide = Slide(
    name = "kodein-koders",
    stateCount = 2,
    outAnimation = if (outFlip) Animations.Flip(Duration.seconds(2)) else null
) { state ->
    Div({
        css {
            fontSize(8.em)
        }
    }) {
        Logo(
            catchPhrase = { Text("painless technology") },
            section = { Text("Koders") }
        )
    }

    Img(
        src = "img/kotlin-certified-trainer.svg",
        alt = "Kotlin Trainer, certified by Jetbrains"
    ) {
        shownIf(state >= 1, Transitions.stamp)
        css {
            height(5.em)
            padding(2.em)
            marginBottom((-5).em)
            alignSelf(AlignSelf.End)
        }
    }
}