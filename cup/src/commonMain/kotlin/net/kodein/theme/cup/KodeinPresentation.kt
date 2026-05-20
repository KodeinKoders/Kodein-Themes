package net.kodein.theme.cup

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.findRootCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import net.kodein.cup.LocalPresentationState
import net.kodein.cup.Presentation
import net.kodein.cup.PresentationState
import net.kodein.cup.SlideGroup
import net.kodein.cup.config.CupConfiguration
import net.kodein.cup.currentSlide
import net.kodein.cup.imgexp.imageExport
import net.kodein.cup.keyevents.keyEvents
import net.kodein.cup.laser.laser
import net.kodein.cup.speaker.speakerWindow
import net.kodein.cup.speaker.windowManagement
import net.kodein.cup.utils.SlideContext
import net.kodein.cup.utils.SlideContextElement
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinMaterial
import net.kodein.themes.cup.generated.resources.Res
import net.kodein.themes.cup.generated.resources.pres_bg_logo
import org.jetbrains.compose.resources.imageResource
import org.kodein.emoji.compose.EmojiService
import kotlin.math.roundToInt


@Composable
private fun BoxScope.ProgressBar(
    presentationState: PresentationState,
    color: Color,
) {
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
                .background(color)
        )
    }
}

public data class KodeinBackgroundLogo(
    val alpha: Float = .5f,
    val bigVisible: Boolean = false,
) : SlideContextElement<KodeinBackgroundLogo>(Key) {
    public companion object Key : SlideContext.Key<KodeinBackgroundLogo>
}

@Composable
public fun KodeinPresentation(
    slides: SlideGroup,
    additionalConfiguration: CupConfiguration = {},
    decoration: @Composable BoxScope.(@Composable BoxScope.() -> Unit) -> Unit = { it() },
) {
    remember {
        // https://github.com/kosi-libs/Emoji.kt?tab=readme-ov-file#initializing-the-emoji-service
        EmojiService.initialize()
    }

    Presentation(
        slides = slides,
        configuration = {
            windowManagement()
            laser()
            speakerWindow()
            imageExport()
            keyEvents()
            additionalConfiguration()
        },
        backgroundColor = KodeinMaterial.darkColorScheme.background
    ) { slidesContent ->
        KodeinCupMaterialTheme {
            val backgroundLogo = LocalPresentationState.current.currentSlide.context[KodeinBackgroundLogo.Key] ?: KodeinBackgroundLogo()

            val imageAlpha by animateFloatAsState(backgroundLogo.alpha, animationSpec = tween(1200))
            val scale by animateFloatAsState(if (backgroundLogo.bigVisible) 1.15f else 2.2f, animationSpec = tween(1200))

            var imageSize: IntSize by remember { mutableStateOf(IntSize.Zero) }
            var rootSize: IntSize by remember { mutableStateOf(IntSize.Zero) }
            val x: Int
            val y: Int
            if (imageSize == IntSize.Zero || rootSize == IntSize.Zero) {
                x = 0
                y = 0
            } else {
                x = animateIntAsState(
                    if (backgroundLogo.bigVisible) rootSize.width - (imageSize.width * .8f).roundToInt()
                    else (rootSize.width / 2f).roundToInt().coerceAtLeast(rootSize.width - (imageSize.width / 1.18f).roundToInt()),
                    animationSpec = tween(1200)
                ).value
                y = animateIntAsState(
                    if (backgroundLogo.bigVisible) (imageSize.height / 3f).roundToInt()
                    else -(imageSize.height / 4.5f).roundToInt(),
                    animationSpec = tween(1200)
                ).value
            }

            Image(
                bitmap = imageResource(Res.drawable.pres_bg_logo),
                contentDescription = null,
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.FillHeight,
                filterQuality = FilterQuality.High,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .onGloballyPositioned {
                        imageSize = it.size
                        rootSize = it.findRootCoordinates().size
                    }
                    .offset {
                        if (imageSize == IntSize.Zero || rootSize == IntSize.Zero) {
                            IntOffset.Zero
                        } else {
                            IntOffset(
                                x = x,
                                y = y,
//                                x = rootSize.width - (imageSize.width * .8f).roundToInt(),
//                                y = (imageSize.height / 3f).roundToInt(),
//                                x = (rootSize.width / 2f).roundToInt().coerceAtLeast(rootSize.width - (imageSize.width / 1.18f).roundToInt()),
//                                y = -(imageSize.height / 4.5f).roundToInt(),
                            )
                        }
                    }
                    .graphicsLayer {
                        rotationZ = -15f
                        scaleX = scale
                        scaleY = scale
//                        scaleX = 1.15f
//                        scaleY = 1.15f
//                        scaleX = 2.2f
//                        scaleY = 2.2f
                        transformOrigin = TransformOrigin(0f, 0.5f)
                        alpha = imageAlpha
                        clip = false
                    }
                    .fillMaxHeight()
            )

            val presentationState = LocalPresentationState.current
            val presentationBackground = presentationState.currentSlide.context[KodeinPresentationBackground]
            val overBackground by animateColorAsState(
                targetValue = presentationBackground?.color ?: Color.Transparent,
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
                    val progressBackground by animateColorAsState(
                        targetValue = presentationBackground?.progressColor ?: Color(KodeinColors.purple600),
                        animationSpec = tween(1_500)
                    )
                    ProgressBar(
                        presentationState = presentationState,
                        color = progressBackground
                    )
                }
            }
        }
    }
}
