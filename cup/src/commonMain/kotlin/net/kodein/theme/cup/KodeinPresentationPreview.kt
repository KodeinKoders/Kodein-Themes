package net.kodein.theme.cup

import androidx.compose.runtime.Composable
import net.kodein.cup.PresentationPreview
import net.kodein.cup.Slide


@Composable
public fun KodeinPresentationPreview(
    slide: Slide,
    step: Int = slide.lastStep,
) {
    PresentationPreview(slide, step) { slides ->
        KodeinPresentation(slides)
    }
}
