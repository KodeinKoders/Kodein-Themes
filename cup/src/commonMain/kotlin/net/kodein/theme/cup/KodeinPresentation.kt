package net.kodein.theme.cup

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import net.kodein.cup.*
import net.kodein.cup.imgexp.imageExport
import net.kodein.cup.laser.laser
import net.kodein.cup.speaker.speakerWindow
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.drawable.KodeinVectors
import net.kodein.theme.compose.drawable.Monogram
import org.kodein.emoji.compose.EmojiService


@Composable
private fun BoxScope.ProgressBar(presentationState: PresentationState) {
    val totalStepCount = presentationState.slides.sumOf { it.stepCount }
    val currentStepCount = presentationState.slides.subList(0, presentationState.currentPosition.slideIndex)
        .sumOf { it.stepCount } + presentationState.currentPosition.step
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .align(Alignment.BottomCenter)
    ) {
        val fraction by animateFloatAsState(
            targetValue = currentStepCount.toFloat() / (totalStepCount - 1).toFloat(),
            animationSpec = tween(300, easing = LinearOutSlowInEasing)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(fraction = fraction)
                .align(Alignment.CenterStart)
                .background(Color(KodeinColors.purple800))
        )
    }
}

@Composable
public fun KodeinPresentation(
    slides: SlideGroup,
    decoration: @Composable BoxScope.(@Composable BoxScope.() -> Unit) -> Unit = { it() },
) {
    remember {
        // https://github.com/kosi-libs/Emoji.kt?tab=readme-ov-file#initializing-the-emoji-service
        EmojiService.initialize()
    }

    KodeinCupMaterialTheme {
        Presentation(
            slides = slides,
            configuration = {
                speakerWindow()
                laser()
                imageExport()
            },
            backgroundColor = MaterialTheme.colorScheme.background
        ) { slidesContent ->
            Image(
                painter = rememberVectorPainter(KodeinVectors.Monogram),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                colorFilter = ColorFilter.tint(Color(KodeinColors.purple800)),
                modifier = Modifier
                    .alpha(0.5f)
                    .fillMaxSize()
                    .offset(x = (-16).dp, y = 64.dp)
            )

            val presentationState = LocalPresentationState.current
            val overBackground by animateColorAsState(
                targetValue = presentationState.currentSlide.context[KodeinPresentationBackground]?.color ?: Color.Transparent,
                animationSpec = tween(1_500)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(overBackground)
            ) {
                decoration {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        CompositionLocalProvider(
                            LocalContentColor provides MaterialTheme.colorScheme.onBackground,
                        ) {
                            slidesContent()
                        }
                    }
                    ProgressBar(presentationState)
                }
            }
        }
    }
}
