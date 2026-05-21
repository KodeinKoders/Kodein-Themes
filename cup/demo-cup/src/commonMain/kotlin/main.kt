import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.theme.cup.KodeinPresentation
import net.kodein.theme.cup.slides.kodeinActivities
import slides.intro
import slides.sourceCode
import slides.texts


fun main() = cupApplication(
    title = "Demo Kodein Presentation"
) {
    KodeinPresentation(
        slides = Slides(
            intro,
            texts,
            sourceCode,
            kodeinActivities,
        ),
    )
}

