package net.kodein.theme.cup.slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import net.kodein.cup.SLIDE_SIZE_16_9
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.cup.Slides
import net.kodein.cup.TransitionSet
import net.kodein.cup.insideTransitionSpecs
import net.kodein.cup.plus
import net.kodein.cup.utils.slideContextOf
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinLogo
import net.kodein.theme.compose.LCTPicon
import net.kodein.theme.compose.Link
import net.kodein.theme.cup.KodeinBackgroundLogo
import net.kodein.theme.cup.KodeinPresentationBackground
import net.kodein.theme.cup.drawable.Jetbrains
import net.kodein.theme.cup.drawable.KodeinCupVectors
import net.kodein.theme.cup.drawable.Kotlin
import net.kodein.theme.cup.kStyled


@Composable
private fun KotlinDivision(
    modifier: Modifier = Modifier,
    subtext: @Composable RowScope.() -> Unit = {},
    division: @Composable () -> Unit,
) {
    Column(modifier) {
        Row {
            Image(
                painter = rememberVectorPainter(KodeinCupVectors.Kotlin),
                contentDescription = null,
                modifier = Modifier.height(50.dp).padding(top = 4.dp, end = 8.dp)
            )
            Column {
                ProvideTextStyle(
                    TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 24.sp
                    )
                ) {
                    Text(
                        text = "Kotlin",
                        fontWeight = FontWeight.Normal
                    )
                    ProvideTextStyle(
                        TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = LCTPicon.Regular,
                        )
                    ) {
                        division()
                    }
                }
            }
        }
        ProvideTextStyle(
            TextStyle(
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Light
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                subtext()
            }
        }
    }
}


private val kodeinKoders by Slide(
    context = KodeinBackgroundLogo(alpha = 1f, bigVisible = true),
    stepCount = 3
) { step ->
    Link("https://kodein.net") {
        KodeinLogo(
            division = "Koders",
            mainFontSize = 32.sp,
        ) { Text("Kotlin Multiplatform Experts") }
    }
    AnimatedVisibility(
        visible = step >= 1,
        enter = fadeIn(tween(750)) + expandVertically(tween(750)),
        exit = fadeOut(tween(750)) + shrinkVertically(tween(750))
    ) {
        Row(
            modifier = Modifier.padding(top = 24.dp)
        ) {
            AnimatedVisibility(
                visible = step >= 2,
                enter = fadeIn(tween(750)) + expandHorizontally(tween(750), clip = false),
                exit = fadeOut(tween(750)) + shrinkHorizontally(tween(750), clip = false)
            ) {
                val density = LocalDensity.current
                val t by transition.animateFloat(
                    transitionSpec = { tween(750) }
                ) {
                    if (it == EnterExitState.Visible) 0f else with(density) { 320.dp.toPx() }
                }
                Row {
                    KotlinDivision(Modifier.graphicsLayer(translationX = t)) { Text("Consulting") }
                    Spacer(Modifier.width(24.dp))
                    KotlinDivision(Modifier.graphicsLayer(translationX = t / 2f)) { Text("Development") }
                    Spacer(Modifier.width(24.dp))
                }
            }
            KotlinDivision(
                subtext = {
                    Image(
                        painter = rememberVectorPainter(KodeinCupVectors.Jetbrains),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(LocalContentColor.current),
                        modifier = Modifier.padding(end = 8.dp).height(16.dp)
                    )
                    Text("Jetbrains Certified")
                }
            ) { Text("Training") }
        }
    }
}

private val kodeinOpenSource by Slide(
    context = slideContextOf(
        KodeinPresentationBackground(
            color = Color(0xFF_46AF6D),
            progressColor = Color(0xFF398E59),
        ),
        KodeinBackgroundLogo(alpha = 1f, bigVisible = true)
    ),
    stepCount = 2
) { step ->
    Link("https://kodein.org") {
        KodeinLogo(
            division = "OpenSource",
            mainFontSize = 32.sp,
            logoColor = Color.White,
            textColor = Color.White,
        ) {
            Text(
                text = kStyled { "Community ${IC("kotlin")} Multiplatform" },
                inlineContent = mapOf(
                    "kotlin" to InlineTextContent(Placeholder(0.8.em, 0.8.em, PlaceholderVerticalAlign.Center)) {
                        Image(
                            painter = rememberVectorPainter(KodeinCupVectors.Kotlin),
                            contentDescription = "Kotlin",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                )
            )
        }
    }

    AnimatedVisibility(
        visible = step >= 1,
        enter = fadeIn(tween(600)) + expandVertically(tween(600)),
        exit = fadeOut(tween(600)) + shrinkVertically(tween(600))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            val density = LocalDensity.current
            listOf("Android", "iOS", "Web", "Desktop", "Server").forEachIndexed { index, platform ->
                val t by transition.animateFloat(
                    transitionSpec = {
                        tween(
                            durationMillis = 600,
                            delayMillis = if (targetState == EnterExitState.Visible) index * 250 else 0
                        )
                    }
                ) {
                    if (it == EnterExitState.Visible) 1f else 0f
                }
                Surface(
                    tonalElevation = 8.dp,
                    shadowElevation = 8.dp,
                    color = Color(KodeinColors.orange100),
                    contentColor = Color(KodeinColors.purple600),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(82.dp)
                        .graphicsLayer(
                            translationY = with(density) { (-(1f - t) * 64).dp.toPx() }
                        )
                ) {
                    Text(
                        text = platform,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp)
                    )
                }
            }
        }
    }
}

public val kodeinActivities: Slides = Slides(
    kodeinKoders,
    kodeinOpenSource,
    specs = {
        it.insideTransitionSpecs(
            startTransitions = TransitionSet.y3dRotation,
            endTransitions = TransitionSet.y3dRotation,
        ) + SlideSpecs(
            size = SLIDE_SIZE_16_9
        )
    }
)
