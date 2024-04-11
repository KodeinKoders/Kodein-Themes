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
import androidx.compose.material.Surface
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinVectorImages
import net.kodein.theme.compose.img.KodeinMonogram
import net.kodein.theme.compose.m2.KodeinMaterialColors
import net.kodein.theme.compose.m2.KodeinMaterialTheme
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.compose.EmojiService
import org.kodein.pres.LocalPresentationState
import org.kodein.pres.Presentation
import org.kodein.pres.PresentationState
import org.kodein.pres.SlideGroup
import org.kodein.pres.imgexp.imageExport
import org.kodein.pres.laser.laser
import org.kodein.pres.sa.LocalDefaultSourceCodeTextStyle
import org.kodein.pres.sa.LocalDefaultSourceCodeTheme
import org.kodein.pres.speaker.speakerMode


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
                speakerMode()
                imageExport()
                laser()
            },
            backgroundColor = MaterialTheme.colors.background
        ) {
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
                        LocalDefaultSourceCodeTheme provides KodeinSourceCodeTheme,
                        LocalDefaultSourceCodeTextStyle provides TextStyle(fontFamily = JetBrainsMono)
                    ) {
                        this@Presentation.Slides()
                    }
                }
                ProgressBar(presentationState)
            }
        }
    }
}
