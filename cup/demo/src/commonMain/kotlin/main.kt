import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.theme.cup.KodeinPresentation
import net.kodein.theme.cup.slides.kodeinActivities
import slides.SourceCode
import slides.Texts
import slides.intro


fun main() = cupApplication(
    title = "Demo Kodein Presentation"
) {
    KodeinPresentation(
        slides = Slides(
            intro,
            Texts,
            SourceCode,
            kodeinActivities,
        ),
    )
}

