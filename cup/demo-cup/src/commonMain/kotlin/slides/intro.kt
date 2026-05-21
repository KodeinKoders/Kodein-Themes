package slides

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import net.kodein.cup.SLIDE_SIZE_16_9
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinLogo
import net.kodein.theme.compose.Link
import net.kodein.theme.cup.KodeinBackgroundLogo


val intro by Slide(
    specs = SlideSpecs(
        size = SLIDE_SIZE_16_9,
    ),
    context = KodeinBackgroundLogo(alpha = 1f, bigVisible = true),
) {
    Column(
        Modifier
            .fillMaxWidth(.9f)
            .fillMaxHeight(),
    ) {
        Link(uri = "https://kodein.net") {
            KodeinLogo(
                division = "Koders",
                mainFontSize = 12.sp,
            ) { Text("Kotlin Multiplatform Experts") }
        }

        Spacer(Modifier.weight(2f))

        val value by rememberInfiniteTransition().animateFloat(
            initialValue = .9f,
            targetValue = 1.1f,
            animationSpec = infiniteRepeatable(
                animation = tween(3000),
                repeatMode = RepeatMode.Reverse
            )
        )
        Text(
            text = buildAnnotatedString {
                appendLine("Titre en")
                withStyle(SpanStyle(color = Color(KodeinColors.Accent))) {
                    append("deux niveaux")
                }
            },
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .scale(value)
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = buildAnnotatedString {
                appendLine("Event name & location")
                withStyle(MaterialTheme.typography.bodyMedium.toSpanStyle().copy(color = Color(KodeinColors.Normal))) {
                    append("DD mon. YYYY")
                }
            },
            style = MaterialTheme.typography.titleMedium,
            color = Color(KodeinColors.Accent)
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = "Presenter(s)",
            color = Color(KodeinColors.Normal),
        )
        Spacer(Modifier.weight(.5f))
    }
}
