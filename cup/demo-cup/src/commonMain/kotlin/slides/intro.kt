package slides

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import net.kodein.cup.SLIDE_SIZE_16_9
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.theme.cup.KodeinBackgroundLogo
import net.kodein.theme.cup.slides.BracketSlideContent


val intro by Slide(
    specs = SlideSpecs(
        size = SLIDE_SIZE_16_9,
    ),
    context = KodeinBackgroundLogo(alpha = 1f, bigVisible = true),
) {
    BracketSlideContent(
        title = {
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.onPrimaryContainer)) {
                        appendLine("Title with")
                    }
                    append("two levels")
                },
            )
        },
        information = {
            Text(
                text = buildAnnotatedString {
                    appendLine("Event name & location")
                    withStyle(MaterialTheme.typography.bodyMedium.toSpanStyle().copy(color = MaterialTheme.colorScheme.onSurfaceVariant)) {
                        append("DD mon. YYYY")
                    }
                },
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onTertiaryFixedVariant,
            )
        },
        authors = {
            Text("Presenter(s)")
        },
    )
}
