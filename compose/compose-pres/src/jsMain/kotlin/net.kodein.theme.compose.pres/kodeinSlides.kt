package net.kodein.theme.compose.pres

import net.kodein.pres.Animations
import net.kodein.pres.Slide
import kotlin.time.Duration


public fun kodeinSlides(component: KodeinFrameworkComponent? = null): List<Slide> = listOf(
    kodeinKodersSlide.copy(
        outAnimation = Animations.Flip(Duration.seconds(2))
    ),
    kodeinFrameworkSlide(component).copy(
        inAnimation = Animations.Flip(Duration.seconds(2))
    )
)