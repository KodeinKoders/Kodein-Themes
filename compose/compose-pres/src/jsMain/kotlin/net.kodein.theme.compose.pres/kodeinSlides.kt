package net.kodein.theme.compose.pres

import net.kodein.pres.Animations
import net.kodein.pres.Slide
import kotlin.time.Duration.Companion.seconds


public fun kodeinSlides(component: KodeinOpenSourceComponent? = null): List<Slide> = listOf(
    kodeinKodersSlide.copy(
        outAnimation = Animations.Flip(2.seconds)
    ),
    kodeinOpenSourceSlide(component).copy(
        inAnimation = Animations.Flip(2.seconds)
    )
)