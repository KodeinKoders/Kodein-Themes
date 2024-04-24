package net.kodein.theme.cup

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
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
import net.kodein.cup.laser.laser
import net.kodein.cup.speaker.speakerWindow
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinVectorImages
import net.kodein.theme.compose.img.KodeinMonogram
import org.kodein.emoji.compose.EmojiService


@Composable
private fun BoxScope.ProgressBar(presentationState: PresentationState) {
    val totalStepCount = presentationState.slides.sumOf { it.stepCount }
    val currentStepCount = presentationState.slides.subList(0, presentationState.currentSlideIndex)
        .sumOf { it.stepCount } + presentationState.currentStep
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
                .background(Color(KodeinColors.dark_purple))
        )
    }
}

@Composable
public fun KodeinPresentation(
    slides: SlideGroup
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
            },
            backgroundColor = MaterialTheme.colors.background
        ) { slidesContent ->
            Image(
                painter = rememberVectorPainter(KodeinVectorImages.Logo.KodeinMonogram),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                colorFilter = ColorFilter.tint(Color(KodeinColors.dark_purple)),
                modifier = Modifier
                    .alpha(0.5f)
                    .fillMaxSize()
                    .offset(x = (-16).dp, y = 64.dp)
            )

            val presentationState = LocalPresentationState.current
            val overBackground by animateColorAsState(
                targetValue = presentationState.currentSlide.user[KodeinPresentationBackground]?.color ?: Color.Transparent,
                animationSpec = tween(1_500)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(overBackground)
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    CompositionLocalProvider(
                        LocalContentColor provides MaterialTheme.colors.onBackground,
                    ) {
                        slidesContent()
                    }
                }
                ProgressBar(presentationState)
            }
        }
    }
}
