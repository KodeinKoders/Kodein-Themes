package net.kodein.theme.cup.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


public val defaultKodeinAnimationDuration: Int = 600

public class AnimatedVisibilityColumnScope(
    columnScope: ColumnScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) : ColumnScope by columnScope, AnimatedVisibilityScope by animatedVisibilityScope

@Composable
public fun ColumnScope.KodeinAnimatedVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    durationMillis: Int = defaultKodeinAnimationDuration,
    easing: Easing = FastOutSlowInEasing,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable AnimatedVisibilityColumnScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(durationMillis, easing = easing)) + expandVertically(tween(durationMillis, easing = easing)),
        exit = fadeOut(tween(durationMillis, easing = easing)) + shrinkVertically(tween(durationMillis, easing = easing)),
        modifier = modifier,
    ) anim@ {
        Column(
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
        ) column@ {
            AnimatedVisibilityColumnScope(this@column, this@anim).content()
        }
    }
}

public class AnimatedVisibilityRowScope(
    rowScope: RowScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) : RowScope by rowScope, AnimatedVisibilityScope by animatedVisibilityScope

@Composable
public fun RowScope.KodeinAnimatedVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    durationMillis: Int = defaultKodeinAnimationDuration,
    easing: Easing = FastOutSlowInEasing,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable AnimatedVisibilityRowScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(durationMillis, easing = easing)) + expandHorizontally(tween(durationMillis, easing = easing)),
        exit = fadeOut(tween(durationMillis, easing = easing)) + shrinkHorizontally(tween(durationMillis, easing = easing)),
        modifier = modifier,
    ) anim@ {
        Row(
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment,
        ) row@ {
            AnimatedVisibilityRowScope(this@row,  this@anim).content()
        }
    }
}

@Composable
public fun KodeinFadeAnimatedVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    durationMillis: Int = defaultKodeinAnimationDuration,
    easing: Easing = FastOutSlowInEasing,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(durationMillis, easing = easing)),
        exit = fadeOut(tween(durationMillis, easing = easing)),
        modifier = modifier,
        content = content
    )
}
