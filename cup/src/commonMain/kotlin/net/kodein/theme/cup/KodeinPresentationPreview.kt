package net.kodein.theme.cup

import androidx.compose.runtime.Composable
import org.kodein.pres.PresentationPreview
import org.kodein.pres.Slide


@Composable
public fun KodeinPresentationPreview(
    slide: Slide,
    step: Int = slide.lastStep,
) {
    PresentationPreview(slide, step) { slides ->
        KodeinPresentation(slides)
    }
}
