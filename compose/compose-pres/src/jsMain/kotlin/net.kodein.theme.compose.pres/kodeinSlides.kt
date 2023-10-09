package net.kodein.theme.compose.pres

import org.kodein.compose.html.pres.Animations
import org.kodein.compose.html.pres.SlidesBuilder
import kotlin.time.Duration.Companion.seconds


public fun SlidesBuilder.kodeinSlides(component: KodeinOpenSourceComponent? = null) {
    +kodeinKodersSlide.copy(
        outAnimation = Animations.Flip(2.seconds)
    )
    +kodeinOpenSourceSlide(component).copy(
        inAnimation = Animations.Flip(2.seconds)
    )
}