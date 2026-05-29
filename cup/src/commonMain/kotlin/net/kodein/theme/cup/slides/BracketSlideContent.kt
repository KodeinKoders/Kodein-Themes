package net.kodein.theme.cup.slides

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.theme.compose.KodeinLogo
import net.kodein.theme.compose.Link


@Composable
public fun BracketSlideContent(
    title: @Composable () -> Unit,
    authors: @Composable () -> Unit,
    topLogoAdditions: @Composable RowScope.() -> Unit = {},
    information: (@Composable () -> Unit)? = null,
    rightContent: @Composable () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
    ) {
        Column(
            Modifier
                .fillMaxHeight(),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Link(uri = "https://kodein.net") {
                    KodeinLogo(
                        division = "Koders",
                        mainFontSize = 12.sp,
                        textColor = MaterialTheme.colorScheme.onSurface,
                    ) { Text("Kotlin Multiplatform Experts") }
                }
                topLogoAdditions()
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
            Box(
                modifier = Modifier
                    .scale(value)
            ) {
                ProvideTextStyle(MaterialTheme.typography.displayLarge.copy(color = MaterialTheme.colorScheme.onTertiaryFixedVariant)) {
                    title()
                }
            }

            Spacer(Modifier.weight(1f))

            if (information != null) {
                ProvideTextStyle(TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant)) {
                    information()
                }
                Spacer(Modifier.weight(1f))
            }

            ProvideTextStyle(TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant)) {
                authors()
            }

            Spacer(Modifier.weight(.5f))
        }

        Spacer(Modifier.weight(1f))

        rightContent()
    }

}
