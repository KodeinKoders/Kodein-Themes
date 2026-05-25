package slides

import androidx.compose.material3.Text
import net.kodein.cup.SLIDE_SIZE_16_9
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.theme.cup.KodeinBackgroundLogo
import net.kodein.theme.cup.slides.BracketSlideContent
import net.kodein.theme.cup.slides.UrlQrCode


val outro by Slide(
    specs = SlideSpecs(
        size = SLIDE_SIZE_16_9,
    ),
    context = KodeinBackgroundLogo(alpha = 1f, bigVisible = true),
) {
    BracketSlideContent(
        title = {
            Text("Thank you!")
        },
        information = {
            UrlQrCode(
                url = "https://p.kodein.net/???",
            )
        },
        authors = {
            Text("Presenter(s)")
        },
    )
}
