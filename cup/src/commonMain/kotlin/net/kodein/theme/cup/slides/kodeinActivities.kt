package net.kodein.theme.cup.slides

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import net.kodein.cup.*
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinVectorImages
import net.kodein.theme.compose.LCTPicon
import net.kodein.theme.cup.ui.KodeinLogo
import net.kodein.theme.cup.KodeinPresentationBackground
import net.kodein.theme.cup.img.KotlinMonogram
import net.kodein.theme.cup.kStyled


@Composable
private fun KotlinDivision(
    modifier: Modifier = Modifier,
    subtext: @Composable () -> Unit = {},
    division: @Composable () -> Unit,
) {
    Column(modifier) {
        Row {
            Image(
                painter = rememberVectorPainter(KodeinVectorImages.Logo.KotlinMonogram),
                contentDescription = null,
                modifier = Modifier.height(42.5.dp).padding(top = 1.dp, end = 8.dp)
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
                        fontWeight = FontWeight.Light
                    )
                    ProvideTextStyle(
                        TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontFamily = LCTPicon.Condensed
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
            subtext()
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
private val kodeinKoders by Slide(
    stepCount = 3
) { step ->
    KodeinLogo("Koders") { Text("painless mobile technology") }
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
                    Spacer(Modifier.width(32.dp))
                    KotlinDivision(Modifier.graphicsLayer(translationX = t / 2f)) { Text("Development") }
                    Spacer(Modifier.width(32.dp))
                }
            }
            KotlinDivision(
                subtext = { Text("Jetbrains Certified") }
            ) { Text("Training") }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
private val kodeinOpenSource by Slide(
    user = KodeinPresentationBackground(Color(0xFF_46AF6D)),
    stepCount = 2
) { step ->
    KodeinLogo(
        division = "OpenSource",
        color = Color.White,
        url = "https://kodein.org"
    ) {
        Text(
            text = kStyled { "painless ${IC("kotlin")} multiplatform" },
            inlineContent = mapOf(
                "kotlin" to InlineTextContent(Placeholder(0.8.em, 0.8.em, PlaceholderVerticalAlign.Center)) {
                    Image(
                        painter = rememberVectorPainter(KodeinVectorImages.Logo.KotlinMonogram),
                        contentDescription = "Kotlin",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            )
        )
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
                    elevation = 8.dp,
                    color = Color(KodeinColors.light),
                    contentColor = Color(KodeinColors.dark),
                    shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp),
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
        val layoutDirection = LocalLayoutDirection.current
        this
            .copy(size = SLIDE_SIZE_16_9)
            .copyWithInsideTransitions(
                config = it,
                startTransitions = TransitionSet.y3dRotation(layoutDirection),
                endTransitions = TransitionSet.y3dRotation(layoutDirection),
            )
    }
)
